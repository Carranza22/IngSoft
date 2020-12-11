package net.cyancj.sistemae_cepuns.entity;

import javax.persistence.*;

@Entity
public class AsistenciaAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asistencia_id", nullable = false, foreignKey = @ForeignKey(name = "fk_asistencia_asisalumno"), referencedColumnName = "id")
    private Asistencia asistencia;
    /*
        @ManyToOne
        @JoinColumn(name="alumno_dni",nullable = false,foreignKey = @ForeignKey(name = "fk_alumno_asisalumno"),referencedColumnName = "dni")
        private Alumno alumno;
    */
    @ManyToOne
    @JoinColumn(name = "matricula_id", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula_asisalumno"), referencedColumnName = "id")
    private Matricula matricula;

    private Boolean check_asistencia;

    public AsistenciaAlumno() {
    }

    public AsistenciaAlumno(Long id, Asistencia asistencia, Matricula matricula, Boolean check_asistencia) {
        this.id = id;
        this.asistencia = asistencia;
        this.matricula = matricula;
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

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Boolean getCheck_asistencia() {
        return check_asistencia;
    }

    public void setCheck_asistencia(Boolean check_asistencia) {
        this.check_asistencia = check_asistencia;
    }

}
