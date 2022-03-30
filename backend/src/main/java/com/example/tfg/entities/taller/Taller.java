package com.example.tfg.entities.taller;

import com.example.tfg.entities.equipo.Equipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String img;

    @ManyToMany (mappedBy = "talleres",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Equipo> equipos;

    protected Taller(){}

    public Taller(String nombreTaller, String categoria, String img) {
        this.nombreTaller = nombreTaller;
        this.categoria = categoria;
        this.img = img;
        this.equipos = new ArrayList<>();

    }

    public Taller(String nombreTaller, String categoria, List<Equipo> equipos, String img) {
        this.nombreTaller = nombreTaller;
        this.categoria = categoria;
        this.equipos = equipos;
        this.img = img;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombre_taller) {
        this.nombreTaller = nombre_taller;
    }

    public String  getCategoria() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "id=" + id +
                ", nombreTaller='" + nombreTaller + '\'' +
                ", categoria=" + categoria +
                ", img='" + img + '\'' +
                ", equipos=" + equipos +
                '}';
    }
}
