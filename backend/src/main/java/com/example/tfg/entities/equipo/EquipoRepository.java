package com.example.tfg.entities.equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EquipoRepository extends JpaRepository<Equipo,Long> {
    public Equipo findByNombreEquipo(String nombreEquipo);

}
