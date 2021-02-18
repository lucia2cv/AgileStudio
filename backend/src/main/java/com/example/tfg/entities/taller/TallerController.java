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
    private TallerService service;

    /*Add taller*/
    @PostMapping(value = "/talleres")
    @ResponseStatus(HttpStatus.CREATED)
    public Taller saveTaller(@RequestBody Taller taller) throws Exception{
        String tempNombre = taller.getNombreTaller();
        if (tempNombre != null && !"".equals(tempNombre)){
            Taller tallerObj = service.fetchByNombreTaller(tempNombre);
            if (tallerObj != null){
                throw new Exception("Taller ya existente");
            }
        }
        service.saveTaller(taller);
        return taller;
    }
}
