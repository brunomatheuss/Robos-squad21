package com.example.residencia.repository;

import com.example.residencia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Usuario, Integer> {

    @Query(value = "select * from Usuario where email = ?1", nativeQuery = true)
    Optional<Usuario> findByEmail(String email);
}