package com.example.tfg.entities.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserController {   //todos los metodos de busqueda

    @Autowired
    private UserRepository userRepository;

    /*Add user*/
    @PostMapping(value = "/users/")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

}
