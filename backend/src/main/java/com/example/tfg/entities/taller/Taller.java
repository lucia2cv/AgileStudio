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
    private String descripcion;
    private String videoconferencia;
    //private List<String> documentos = new ArrayList<>(4);

    @ManyToMany (mappedBy = "talleres",fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Equipo> equipos;

    protected Taller(){}

    public Taller(String nombreTaller, String categoria, String img, String descripcion, String videoconferencia) {
        this.nombreTaller = nombreTaller;
        this.categoria = categoria;
        this.img = img;
        this.equipos = new ArrayList<>();
        this.descripcion = descripcion;
        this.videoconferencia = videoconferencia;
        //this.documentos = documentos;
    }

    public Taller(String nombreTaller, String categoria, List<Equipo> equipos, String img, String descripcion) {
        this.nombreTaller = nombreTaller;
        this.categoria = categoria;
        this.equipos = equipos;
        this.img = img;
        this.descripcion = descripcion;
        //this.documentos = documentos;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombre_taller) {
        this.nombreTaller = nombre_taller;
    }

    public String getCategoria() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVideoconferencia() {
        return videoconferencia;
    }

    public void setVideoconferencia(String videoconferencia) {
        this.videoconferencia = videoconferencia;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "id=" + id +
                ", nombreTaller='" + nombreTaller + '\'' +
                ", categoria='" + categoria + '\'' +
                ", img='" + img + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", videoconferencia='" + videoconferencia + '\'' +
                ", equipos=" + equipos +
                '}';
    }
}
