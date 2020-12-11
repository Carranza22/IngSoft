package net.cyancj.sistemae_cepuns.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre_carrera;

    @ManyToOne
    @JsonIgnoreProperties("facultad")
    @JoinColumn(name = "facultad_id", nullable = false, foreignKey = @ForeignKey(name="fk_facultad"),referencedColumnName = "id")
    private Facultad facultad;

    public Carrera(){

    }


    public Carrera(Long id, String nombre_carrera, Facultad facultad) {
        this.id = id;
        this.nombre_carrera = nombre_carrera;
        this.facultad = facultad;
    }

    public Long getId_carrera() {
        return id;
    }

    public void setId_carrera(Long id) {
        this.id = id;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    @JsonIgnore
    @JsonProperty(value = "facultad")
    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
}
