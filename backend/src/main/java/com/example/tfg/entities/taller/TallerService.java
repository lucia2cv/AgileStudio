package com.example.tfg.entities.taller;

import com.example.tfg.entities.equipo.Equipo;
import com.example.tfg.entities.equipo.EquipoRepository;
import com.example.tfg.entities.usuario.UserRepository;
import com.example.tfg.entities.usuario.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EquipoRepository equipoRepository;

    public void saveTaller (Taller taller){
        tallerRepository.save(taller);
    }

    public Taller fetchByNombreTaller(String nombreTaller){
        return tallerRepository.findByNombreTaller(nombreTaller);
    }

    public List<Taller> findAll(){ return tallerRepository.findAll();}

    public List<Taller> fetchByCategory(String categoria, String id) {
        List<Taller> list=new ArrayList<>();
        Users user = userRepository.findUsersById(Long.parseLong(id));
        List<Equipo> listEquipos= user.getEquipos();
        for (Equipo equipo : listEquipos) {
            List<Taller> tallerList = equipo.getTalleres();
            for (Taller taller : tallerList) {
                if (taller.getCategoria().equals(categoria) && !list.contains(taller)) {
                    list.add(taller);
                }
            }
        }
        return list;
    }

    public Taller fetchById(Long id) {
        Optional<Taller> opt = tallerRepository.findById(id);
        return opt.orElse(null);
    }
}
