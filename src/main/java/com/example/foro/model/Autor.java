package com.example.foro.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Otros campos y métodos si es necesario
}
