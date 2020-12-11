package net.cyancj.sistemae_cepuns.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;



@Entity
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre_facultad;

    @OneToMany(targetEntity = Carrera.class, mappedBy = "facultad",cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Carrera> carreras;

    public Facultad(){

    }

    public Facultad(Long id, String nombre_facultad, List<Carrera> carreras) {
        this.id = id;
        this.nombre_facultad = nombre_facultad;
        this.carreras = carreras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
}

