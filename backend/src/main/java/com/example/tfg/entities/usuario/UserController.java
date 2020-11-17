package com.example.tfg.entities.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*Add user*/
    @PostMapping(value = "/usuarios/")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }
}
