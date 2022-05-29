package com.example.tfg.entities.equipo;

import com.example.tfg.entities.taller.Taller;
import com.example.tfg.entities.taller.TallerRepository;
import com.example.tfg.entities.usuario.UserRepository;
import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TallerRepository tallerRepository;

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
        return equiposUsuarios;
    }

    public Equipo fetchById(Long id) {
        Optional<Equipo> opt = equipoRepository.findById(id);
        return opt.orElse(null);
    }

    public Equipo saveNewTeam(TeamForm teamForm) throws IllegalArgumentException {
        Equipo equipo;
        equipo = new Equipo();
        long [] workshopFormMembers = teamForm.getMiembros();
        List<Users> miembros = new ArrayList<>();
        List<Taller> tallerList = new ArrayList<>();
        equipo.setNombreEquipo(teamForm.getNombre());
        equipo.setLogoImg(teamForm.getLogo());
        for (long id: workshopFormMembers) {
            Users user = userRepository.findUsersById(id);
            miembros.add(user);
        }
        equipo.setMiembros(miembros);
        equipoRepository.save(equipo);
        for (long id: workshopFormMembers) {
            Users user = userRepository.findUsersById(id);
            user.getEquipos().add(equipo);
            userRepository.save(user);
        }

        for (long idTaller: teamForm.getTalleres()) {
            Taller taller = tallerRepository.findTallerById(idTaller);
            taller.getEquipos().add(equipo);
            tallerRepository.save(taller);
            tallerList.add(taller);
        }
        equipo.setTalleres(tallerList);
        return equipoRepository.save(equipo);
    }
}
