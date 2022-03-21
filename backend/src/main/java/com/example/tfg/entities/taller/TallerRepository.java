package com.example.tfg.entities.taller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TallerRepository extends JpaRepository<Taller, Long> {
    public Taller findByNombreTaller(String nombreTaller);
}
