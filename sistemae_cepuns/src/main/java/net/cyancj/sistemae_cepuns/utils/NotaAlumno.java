package net.cyancj.sistemae_cepuns.utils;

import net.cyancj.sistemae_cepuns.entity.Alumno;

public class NotaAlumno {
    private Alumno alumno;
    private Double nota1;
    private Double nota2;
    private Double nota3;

    public NotaAlumno() {

    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "NotaAlumno{" +
                "alumno=" + alumno +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }
}
