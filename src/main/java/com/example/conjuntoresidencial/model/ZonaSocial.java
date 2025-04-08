package com.example.conjuntoresidencial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ZonaSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZona;

    private String nombre;
    private String ubicacion;
    private Integer capacidad;

}
