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

    @ManyToMany (mappedBy = "talleres")
    private List<Equipo> equipos;

    protected Taller(){}

    public Taller(String nombre_taller, String categoria) {
        this.nombre_taller = nombre_taller;
        this.categoria = categoria;
        this.equipos = new ArrayList<>();

    }

    public Taller(String nombre_taller, String categoria, List<Equipo> equipos) {
        this.nombre_taller = nombre_taller;
        this.categoria = categoria;
        this.equipos = equipos;
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

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
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
