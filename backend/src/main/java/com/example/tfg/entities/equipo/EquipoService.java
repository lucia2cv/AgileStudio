package com.example.tfg.entities.equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public void  saveEquipo (Equipo equipo){
        equipoRepository.save(equipo);
    }
    public Equipo fetchTeamByNombreEquipo(String nombreEquipo){
        return equipoRepository.findByNombreEquipo(nombreEquipo);
    }
    public List<Equipo> findAll(){
        return equipoRepository.findAll();
    }
}
