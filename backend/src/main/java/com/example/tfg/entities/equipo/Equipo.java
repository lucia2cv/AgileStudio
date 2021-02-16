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

    private String nombre_equipo;

    @OneToMany(mappedBy = "equipo")
    private List<Users> miembros;

    @ManyToMany
    private List<Taller> talleres;

    protected Equipo(){}

    public Equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
        this.miembros = new ArrayList<>();
        this.talleres = new ArrayList<>();
    }

    public Equipo(String nombre_equipo, List<Users> miembros) {
        this.nombre_equipo = nombre_equipo;
        this.miembros = miembros;

    }

    public Equipo(String nombre_equipo, List<Users> miembros, List<Taller> talleres) {
        this.nombre_equipo = nombre_equipo;
        this.miembros = miembros;
        this.talleres = talleres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;

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
                ", nombre_equipo='" + nombre_equipo + '\'' +
                ", miembros=" + miembros +
                '}';
    }
}
