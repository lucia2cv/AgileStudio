package com.example.tfg.entities.equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EquipoRepository extends JpaRepository<Equipo,Long> {
    public Equipo findByNombreEquipo(String nombreEquipo);
}
