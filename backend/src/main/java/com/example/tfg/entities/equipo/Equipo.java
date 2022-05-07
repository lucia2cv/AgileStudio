package com.example.tfg.entities.equipo;

import com.example.tfg.entities.taller.Taller;
import com.example.tfg.entities.usuario.Users;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Equipo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombreEquipo;
    private String logoImg;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonManagedReference
    private List<Users> miembros;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Taller> talleres;

    protected Equipo(){}

    public Equipo(String nombreEquipo, String logoImg) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = new ArrayList<>();
        this.talleres = new ArrayList<>();
        this.logoImg = logoImg;
    }

    public Equipo(String nombreEquipo, List<Users> miembros) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = miembros;

    }

    public Equipo(String nombreEquipo, List<Users> miembros, List<Taller> talleres, String logoImg) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = miembros;
        this.talleres = talleres;
        this.logoImg = logoImg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombre_equipo) {
        this.nombreEquipo = nombre_equipo;

    }

    public List<Users> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Users> miembros) {
        this.miembros = miembros;
    }

    public List<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(List<Taller> talleres) {
        this.talleres = talleres;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre_equipo='" + nombreEquipo + '\'' +
                ", miembros=" + miembros +
                '}';
    }
}
