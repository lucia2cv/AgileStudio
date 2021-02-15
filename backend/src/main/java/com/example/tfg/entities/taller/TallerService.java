package com.example.tfg.entities.taller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    public List<Taller> findAll(){ return tallerRepository.findAll();}
}
