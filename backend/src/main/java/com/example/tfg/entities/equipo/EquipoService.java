package com.example.tfg.entities.equipo;

import com.example.tfg.entities.taller.Taller;
import com.example.tfg.entities.usuario.UserRepository;
import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private UserRepository userRepository;

    public void  saveEquipo (Equipo equipo){
        equipoRepository.save(equipo);
    }
    public Equipo fetchTeamByNombreEquipo(String nombreEquipo){
        return equipoRepository.findByNombreEquipo(nombreEquipo);
    }
    /*public List<Equipo> findAll(){
        return equipoRepository.findAll();
    }*/

    public List<Equipo> getuserTeams (Long id) {
        Users user = userRepository.findUsersById(id);
        List<Equipo> equiposUsuarios = user.getEquipos();
        System.out.println("EquipoService lista equipos: " + equiposUsuarios);
        return equiposUsuarios;
    }

    public Equipo fetchById(Long id) {
        Optional<Equipo> opt = equipoRepository.findById(id);
        return opt.orElse(null);
    }
}
