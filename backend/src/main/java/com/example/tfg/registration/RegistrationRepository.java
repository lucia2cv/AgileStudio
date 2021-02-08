package com.example.tfg.registration;

import com.example.tfg.entities.usuario.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository <User, Long> {
    public User findByEmail(String email);
}
