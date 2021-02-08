package com.example.tfg.entities.usuario;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String password;
    private String email;
    private String rol;
    private String equipo;
    //private long id_equipo;

    //Constructor needed for the load from the BBDD

    protected User(){}

    public User(String nombre, String password, String email, String rol, String nombreEquipo /*long id_equipo*/) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.equipo = nombreEquipo;
        //this.id_equipo = id_equipo;
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    /*public long getId_equipo() {
        return id_equipo;
    }
    public void setId_equipo(long id_equipo) {
        this.id_equipo = id_equipo;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", equipo='" + equipo + '\'' +
                '}';
    }
}
