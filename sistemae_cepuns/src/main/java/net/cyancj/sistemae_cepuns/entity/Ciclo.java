package net.cyancj.sistemae_cepuns.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4, nullable = false)
    private String anio;

    @Column(length = 1, nullable = false)
    private int n_ciclo;

    @Column(length = 1, nullable = false)
    private int estado_matricula;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    public Ciclo() {
    }

    public Ciclo(Long id, String anio, int n_ciclo, int estado_matricula, Date fecha_inicio, Date fecha_fin) {
        this.id = id;
        this.anio = anio;
        this.n_ciclo = n_ciclo;
        this.estado_matricula = estado_matricula;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getN_ciclo() {
        return n_ciclo;
    }

    public void setN_ciclo(int n_ciclo) {
        this.n_ciclo = n_ciclo;
    }

    public int getEstado_matricula() {
        return estado_matricula;
    }

    public void setEstado_matricula(int estado_matricula) {
        this.estado_matricula = estado_matricula;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
