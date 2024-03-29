package com.example.tfg.entities.usuario;

import com.example.tfg.entities.equipo.Equipo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String password;
    private String email;
    private String rol;
    private String img;

    @ManyToMany(mappedBy = "miembros",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Equipo> equipos;
    //Constructor needed for the load from the BBDD

    /*@ManyToOne
    @JsonIgnore
    //@JsonBackReference
    private Equipo equipo;
    //private long id_equipo;
    */
    protected Users(){}

    public Users(String nombre, String password, String email, String rol, List<Equipo> equipos, String img /*long id_equipo*/) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = rol;
       this.equipos = equipos;
       this.img = img;
        //this.id_equipo = id_equipo;
    }

    public Users(String nombre, String password, String email, String rol, String img) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.equipos = new ArrayList<>();
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String contraseña) {
        this.password = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
               // ", equipo='" + equipo + '\'' +
                '}';
    }
}
