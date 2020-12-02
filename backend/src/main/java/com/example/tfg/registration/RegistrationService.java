package com.example.tfg.registration;

import com.example.tfg.entities.usuario.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repository;
    public User  saveUser(User user){

        return repository.save(user);

    }

    public  User fetchUserByEmail(String email){
       return repository.findByEmail(email);
    }
}
