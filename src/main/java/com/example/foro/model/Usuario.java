package com.example.foro.model;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;

    // Getters y Setters
}