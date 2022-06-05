package com.example.tfg.entities.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Users, Long> {
    Users findByNombre(String nombre);
    Users findUsersById (Long id);
}
