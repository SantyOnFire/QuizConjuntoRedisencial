package com.example.conjuntoresidencial.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ReservaZona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    private LocalDate fecha;
    private LocalTime horaInicio;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    private ZonaSocial zona;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    // Getters y setters
}
