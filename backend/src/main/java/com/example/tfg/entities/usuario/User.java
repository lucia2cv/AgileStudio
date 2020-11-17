package com.example.tfg.entities.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String contraseña;
    private String email;
    private String rol;
    private long id_equipo;

    //Constructor needed for the load from the BBDD

    protected User(){}

    public User(long id, String nombre, String contraseña, String email, String rol, long id_equipo) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.rol = rol;
        this.id_equipo = id_equipo;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(long id_equipo) {
        this.id_equipo = id_equipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", id_equipo=" + id_equipo +
                '}';
    }
}
