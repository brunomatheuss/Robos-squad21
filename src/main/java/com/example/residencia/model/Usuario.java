package com.example.residencia.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = ("Usuario"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String senha;
    private boolean adm;

}
