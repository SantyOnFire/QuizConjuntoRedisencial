package com.example.conjuntoresidencial.repository;

import com.example.conjuntoresidencial.model.Propietario;
import com.example.conjuntoresidencial.model.ReservaParqueadero;
import com.example.conjuntoresidencial.model.ReservaZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {

    @Query(value = """
            SELECT rz.*, zs.nombre AS zona_nombre 
            FROM reserva_zona rz 
            JOIN zona_social zs ON rz.id_zona = zs.id_zona 
            WHERE rz.id_propietario = :idPropietario
            """, nativeQuery = true)
    List<Object[]> findReservasZonaByPropietario(@Param("idPropietario") Integer idPropietario);

    @Query(value = """
            SELECT p.nombre AS propietario, v.nombre AS visitante 
            FROM propietario p 
            JOIN visitante v ON v.id_propietario = p.id_propietario 
            WHERE p.id_propietario = :idPropietario
            """, nativeQuery = true)
    List<Object[]> findVisitantesByPropietario(@Param("idPropietario") Integer idPropietario);

    @Query(value = """
            SELECT * FROM reserva_parqueadero 
            WHERE id_propietario = :idPropietario
            """, nativeQuery = true)
    List<ReservaParqueadero> findParqueaderosByPropietario(@Param("idPropietario") Integer idPropietario);

    @Query(value = """
            SELECT * FROM reserva_zona 
            WHERE fecha = :fecha
            """, nativeQuery = true)
    List<ReservaZona> findReservasZonaByFecha(@Param("fecha") LocalDate fecha);
}
