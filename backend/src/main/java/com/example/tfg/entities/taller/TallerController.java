package com.example.tfg.entities.taller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TallerController {
    @Autowired
    private TallerRepository tallerRepository;

    /*Add taller*/
    @PostMapping(value = "/taller/")
    @ResponseStatus(HttpStatus.CREATED)
    public Taller newTaller(@RequestBody Taller taller){
        tallerRepository.save(taller);
        return taller;
    }
}
