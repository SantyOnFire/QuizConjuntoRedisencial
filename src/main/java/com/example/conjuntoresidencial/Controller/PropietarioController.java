package com.example.conjuntoresidencial.Controller;

import com.example.conjuntoresidencial.model.ReservaParqueadero;
import com.example.conjuntoresidencial.model.ReservaZona;
import com.example.conjuntoresidencial.Service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    // Mostrar las reservas de zona social que ha hecho un propietario
    @GetMapping("/{id}/reservas-zona")
    public List<Object[]> getReservasZonaByPropietario(@PathVariable Integer id) {
        return propietarioService.getReservasZonaByPropietario(id);
    }

    // Listar el propietario con los visitantes que ha tenido
    @GetMapping("/{id}/visitantes")
    public List<Object[]> getVisitantesByPropietario(@PathVariable Integer id) {
        return propietarioService.getVisitantesByPropietario(id);
    }

    // Listar los parqueaderos que tiene asignado un propietario
    @GetMapping("/{id}/parqueaderos")
    public List<ReservaParqueadero> getParqueaderosByPropietario(@PathVariable Integer id) {
        return propietarioService.getParqueaderosByPropietario(id);
    }

    // Mostrar las reservas de zona por fecha
    @GetMapping("/reservas-zona/fecha")
    public List<ReservaZona> getReservasZonaByFecha(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return propietarioService.getReservasZonaByFecha(fecha);
    }
}
