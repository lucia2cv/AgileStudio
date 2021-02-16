package com.example.tfg.entities.equipo;

import com.example.tfg.entities.taller.Taller;
import com.example.tfg.entities.usuario.Users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombreEquipo;

    @OneToMany(mappedBy = "equipo")
    private List<Users> miembros;

    @ManyToMany
    private List<Taller> talleres;

    protected Equipo(){}

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = new ArrayList<>();
        this.talleres = new ArrayList<>();
    }

    public Equipo(String nombreEquipo, List<Users> miembros) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = miembros;

    }

    public Equipo(String nombreEquipo, List<Users> miembros, List<Taller> talleres) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = miembros;
        this.talleres = talleres;
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

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre_equipo='" + nombreEquipo + '\'' +
                ", miembros=" + miembros +
                '}';
    }
}
