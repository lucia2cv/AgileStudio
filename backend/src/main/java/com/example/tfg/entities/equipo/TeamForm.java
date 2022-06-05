package com.example.tfg.entities.equipo;

import java.util.Arrays;

public class TeamForm {

    private String nombre;
    private String logo;
    private long[] miembros;
    private long[] talleres;

    public TeamForm() { }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long[] getMiembros() {
        return miembros;
    }

    public void setMiembros(long[] miembros) {
        this.miembros = miembros;
    }

    public long[] getTalleres() {
        return talleres;
    }

    public void setTalleres(long[] talleres) {
        this.talleres = talleres;
    }

    @Override
    public String toString() {
        return "TeamForm{" +
                "nombre='" + nombre + '\'' +
                ", logo='" + logo + '\'' +
                ", miembros=" + Arrays.toString(miembros) +
                ", talleres=" + Arrays.toString(talleres) +
                '}';
    }
}

