package com.example.tfg.registration;

import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repository;
    public void   saveUser(Users users){

        repository.save(users);

    }
    public Users fetchUserByEmail(String email){
       return repository.findByEmail(email);
    }
}
