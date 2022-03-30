package com.example.tfg.entities.taller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    public void saveTaller (Taller taller){
        tallerRepository.save(taller);
    }

    public Taller fetchByNombreTaller(String nombreTaller){
        return tallerRepository.findByNombreTaller(nombreTaller);
    }

    public List<Taller> findAll(){ return tallerRepository.findAll();}

}
