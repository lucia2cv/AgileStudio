package com.example.tfg.entities.taller;

import com.example.tfg.entities.equipo.Equipo;
import com.example.tfg.entities.usuario.UserRepository;
import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/talleres")
public class TallerController {
    @Autowired
    private TallerService service;
    @Autowired
    private TallerRepository tallerRepository;

    @Autowired
    private UserRepository userRepository;
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

    @GetMapping("/")
    public List<Taller> getAllWorkshops(Long id){
        Users user = userRepository.findUsersById(id);
        List<Equipo> equiposUsuarios = user.getEquipos();
        List<Taller> talleres = new ArrayList<>();
        List<Taller> talleresEquipo;
        for (Equipo eq: equiposUsuarios) {
           talleresEquipo = eq.getTalleres();
            for (Taller t: talleresEquipo) {
                if(!talleres.contains(t)) {
                    talleres.add(t);
                }
            }
        }
        return  talleres;
    }

    @GetMapping("/{categoria}")
    public List<Taller> getAllWorkshopsByCategory(@PathVariable String categoria, String id){
        List<Taller> workshops = service.fetchByCategory(categoria, id);
        return workshops;
    }

    @GetMapping("/un-taller/{id}")
    public Taller getWorkshopsById(@PathVariable Long id){
        Taller workshop = service.fetchById(id);
        return workshop;
    }

}
