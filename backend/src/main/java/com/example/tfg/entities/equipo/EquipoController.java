package com.example.tfg.entities.equipo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;

    /*Add equipo*/
    @PostMapping(value = "/equipos/")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo newEquipo(@RequestBody Equipo equipo){
        equipoRepository.save(equipo);
        return equipo;
    }
}
