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
    private EquipoService service;

    /*Add equipo*/
    @PostMapping(value = "/equipo")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo saveEquipo(@RequestBody Equipo equipo) throws Exception{
        String tempNombre = equipo.getNombreEquipo();
        if (tempNombre != null && !"".equals(tempNombre)) {
            Equipo equipoObj = service.fetchTeamByNombreEquipo(tempNombre);
            if(equipoObj != null){
                throw new Exception("Equipo ya existente");
            }
        }
        service.saveEquipo(equipo);
        return equipo;
    }
}
