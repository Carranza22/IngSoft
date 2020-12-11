package net.cyancj.sistemae_cepuns.entity;

import javax.persistence.*;

@Entity
public class AsistenciaDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asistencia_id",nullable = false, foreignKey = @ForeignKey(name = "fk_asistencia_asisdocente"), referencedColumnName = "id")
    private Asistencia asistencia;

    @ManyToOne
    @JoinColumn(name="docente_dni",nullable = false,foreignKey = @ForeignKey(name = "fk_docente_asisdocente"),referencedColumnName = "dni")
    private Docente docente;

    private Boolean check_asistencia;

    public AsistenciaDocente() {
    }

    public AsistenciaDocente(Long id, Asistencia asistencia, Docente docente, Boolean check_asistencia) {
        this.id = id;
        this.asistencia = asistencia;
        this.docente = docente;
        this.check_asistencia = check_asistencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Boolean getCheck_asistencia() {
        return check_asistencia;
    }

    public void setCheck_asistencia(Boolean check_asistencia) {
        this.check_asistencia = check_asistencia;
    }

}
