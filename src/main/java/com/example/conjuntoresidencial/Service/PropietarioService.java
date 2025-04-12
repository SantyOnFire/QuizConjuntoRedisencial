package com.example.conjuntoresidencial.Service;

import com.example.conjuntoresidencial.model.ReservaParqueadero;
import com.example.conjuntoresidencial.model.ReservaZona;
import com.example.conjuntoresidencial.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Object[]> getReservasZonaByPropietario(Integer idPropietario) {
        return propietarioRepository.findReservasZonaByPropietario(idPropietario);
    }

    public List<Object[]> getVisitantesByPropietario(Integer idPropietario) {
        return propietarioRepository.findVisitantesByPropietario(idPropietario);
    }

    public List<ReservaParqueadero> getParqueaderosByPropietario(Integer idPropietario) {
        return propietarioRepository.findParqueaderosByPropietario(idPropietario);
    }

    public List<ReservaZona> getReservasZonaByFecha(LocalDate fecha) {
        return propietarioRepository.findReservasZonaByFecha(fecha);
    }
}