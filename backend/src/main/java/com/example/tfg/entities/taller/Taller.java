package com.example.tfg.entities.taller;

import com.example.tfg.entities.equipo.Equipo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Taller {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombreTaller;
    private String categoria;

    @ManyToMany (mappedBy = "talleres",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Equipo> equipos;

    protected Taller(){}

    public Taller(String nombreTaller, String categoria) {
        this.nombreTaller = nombreTaller;
        this.categoria = categoria;
        this.equipos = new ArrayList<>();

    }

    public Taller(String nombreTaller, String categoria, List<Equipo> equipos) {
        this.nombreTaller = nombreTaller;
        this.categoria = categoria;
        this.equipos = equipos;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombre_taller) {
        this.nombreTaller = nombre_taller;
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
                ", nombre_taller='" + nombreTaller + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
