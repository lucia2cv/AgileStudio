package com.example.tfg.entities.equipo;


import com.example.tfg.entities.taller.TallerService;
import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
@RequestMapping("/home")*/

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/equipos")
public class EquipoController {

    /*@Autowired
    private EquipoRepository equipoRepository;*/

    @Autowired
    private EquipoService service;

    @GetMapping("/")
    public List<Equipo> getAllEquipos(Long id){
        return service.getuserTeams(id);
    }
   /* @Autowired
    private EquipoService service;

    /*Add equipo*/
    /*@PostMapping(value = "/equipo")
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
    } */
}
