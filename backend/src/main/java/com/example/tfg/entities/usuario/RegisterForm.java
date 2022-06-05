package com.example.tfg.entities.usuario;


import java.util.Arrays;

public class RegisterForm {
    private String nombre;
    private String email;
    private String password;
    private String rol;
    private long[] teams;
    private String img;

    public RegisterForm() { }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public long[] getTeams() {
        return teams;
    }

    public void setTeams(long[] teams) {
        this.teams = teams;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", teams=" + Arrays.toString(teams) +
                ", img='" + img + '\'' +
                '}';
    }
}
