package com.example.tfg.entities.taller;

import com.example.tfg.entities.equipo.Equipo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Taller {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombre_taller;
    private String categoria;




    protected Taller(){}

    public Taller(String nombre_taller, String categoria) {
        this.nombre_taller = nombre_taller;
        this.categoria = categoria;

    }


    public String getNombre_taller() {
        return nombre_taller;
    }

    public void setNombre_taller(String nombre_taller) {
        this.nombre_taller = nombre_taller;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    @Override
    public String toString() {
        return "Taller{" +
                "id=" + id +
                ", nombre_taller='" + nombre_taller + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
