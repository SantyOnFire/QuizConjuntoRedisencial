package com.example.conjuntoresidencial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;
@Data

@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropietario;

    private String nombre;
    private String cedula;
    private LocalDate fechaVisita;
    private LocalTime horaEntrada;


}