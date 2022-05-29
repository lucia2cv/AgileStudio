package com.example.tfg.entities.equipo;


import com.example.tfg.entities.taller.Taller;
import com.example.tfg.entities.taller.TallerService;
import com.example.tfg.entities.taller.WorkshopForm;
import com.example.tfg.entities.usuario.UserService;
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
    private UserService userService;
    private TallerService tallerService;

    public EquipoController(UserService userService, TallerService tallerService) {
        this.userService = userService;
        this.tallerService = tallerService;
    }

    @GetMapping("/")
    public List<Equipo> getAllEquipos(Long id){
        return service.getuserTeams(id);
    }

    @GetMapping("/un-equipo/{id}")
    public Equipo getWorkshopsById(@PathVariable Long id){
        Equipo team = service.fetchById(id);
        return team;
    }
    @GetMapping("/crear/equipo")
    public List<Users> getAllUsers(){
        return userService.getAllUsersList();
    }
   @GetMapping("/crear")
    public List<Taller> getAllWorkshopsList(){
        return tallerService.getAllWorkshopsList();
    }
    @PostMapping("/crear/equipo")
    public ResponseEntity<Long> saveTeam(@RequestBody TeamForm teamForm){

        try {
            if (teamForm.getMiembros().length == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            service.saveNewTeam(teamForm);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
