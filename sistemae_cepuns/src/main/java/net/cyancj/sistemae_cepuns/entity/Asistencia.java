package net.cyancj.sistemae_cepuns.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ciclo_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ciclo"), referencedColumnName = "id")
    private Ciclo ciclo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @OneToMany(targetEntity = AsistenciaAlumno.class, mappedBy = "asistencia", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AsistenciaAlumno> listaAlumno;

    @OneToMany(targetEntity = AsistenciaDocente.class, mappedBy = "asistencia", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AsistenciaDocente> listaDocente;

    public Asistencia() {
    }

    public Asistencia(Long id, Ciclo ciclo, Date fecha, List<AsistenciaAlumno> listaAlumno, List<AsistenciaDocente> listaDocente) {
        this.id = id;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.listaAlumno = listaAlumno;
        this.listaDocente = listaDocente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<AsistenciaAlumno> getListaAlumno() {
        return listaAlumno;
    }

    public void setListaAlumno(List<AsistenciaAlumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }

    public List<AsistenciaDocente> getListaDocente() {
        return listaDocente;
    }

    public void setListaDocente(List<AsistenciaDocente> listaDocente) {
        this.listaDocente = listaDocente;
    }
}
