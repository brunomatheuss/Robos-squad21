package com.example.residencia.controller;

import com.example.residencia.model.Usuario;
import com.example.residencia.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String goHome() {
        return "Página inicial, Seja Bem-vindo!";
    }

    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUser(@RequestBody Usuario usuario) {
        usuario.setAdm(false);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario result = userRepo.save(usuario);
        if (result.getId() > 0) {
            return ResponseEntity.ok("Usuario Salvo");
        }
        return ResponseEntity.status(404).body("Erro, Usuario nao foi salvo.");
    }

    @PostMapping("/admin/save")
    public ResponseEntity<Object> saveAdmin(@RequestBody Usuario usuario) {
        usuario.setAdm(true);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario result = userRepo.save(usuario);
        if (result.getId() > 0) {
            return ResponseEntity.ok("Administrador Salvo");
        }
        return ResponseEntity.status(404).body("Erro, Administrador nao foi salvo.");
    }

    @GetMapping("/users/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/user/single")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('User')")
    public ResponseEntity<Object> getAnyDetails() {
        return ResponseEntity.ok(userRepo.findByEmail(getLoggedinUserDetails().getUsername()));
    }

    public UserDetails getLoggedinUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }
}
