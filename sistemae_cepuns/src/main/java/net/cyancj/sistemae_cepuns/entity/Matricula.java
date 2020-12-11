package net.cyancj.sistemae_cepuns.entity;

import javax.persistence.*;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 7, nullable = false)
    private String codigo_voucher;
    @OneToOne
    @JoinColumn(name = "alumno_dni", nullable = false, foreignKey = @ForeignKey(name = "fk_Alumno"), referencedColumnName = "dni")
    private Alumno alumno;

    @OneToOne
    @JoinColumn(name = "ciclo_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ciclo"), referencedColumnName = "id")
    private Ciclo ciclo;

    @OneToOne
    @JoinColumn(name = "carrera_id", nullable = false, foreignKey = @ForeignKey(name = "fk_carrera"), referencedColumnName = "id")
    private Carrera carrera;


    public Matricula() {
    }

    public Matricula(Long id, String codigo_voucher, Alumno alumno, Ciclo ciclo, Carrera carrera) {
        this.id = id;
        this.codigo_voucher = codigo_voucher;
        this.alumno = alumno;
        this.ciclo = ciclo;
        this.carrera = carrera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_voucher() {
        return codigo_voucher;
    }

    public void setCodigo_voucher(String codigo_voucher) {
        this.codigo_voucher = codigo_voucher;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
