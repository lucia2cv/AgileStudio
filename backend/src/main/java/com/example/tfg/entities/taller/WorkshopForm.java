package com.example.tfg.entities.taller;

import java.util.Arrays;

public class WorkshopForm {


    private String nombre;
    private String categoria;
    private String img;
    private long[] teams;
    private String descripcion;

    public WorkshopForm() {}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long[] getTeams() {
        return teams;
    }

    public void setTeams(long[] teams) {
        this.teams = teams;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "WorkshopForm{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", img='" + img + '\'' +
                ", teams=" + Arrays.toString(teams) +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
