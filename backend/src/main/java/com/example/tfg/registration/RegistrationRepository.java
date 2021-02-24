package com.example.tfg.registration;

import com.example.tfg.entities.usuario.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository <Users, Long> {
    public Users findByEmail(String email);
}
