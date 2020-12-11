package net.cyancj.sistemae_cepuns.utils;

import net.cyancj.sistemae_cepuns.entity.AsistenciaAlumno;

import java.util.List;

public class FormAsistenciaAlumno {
    private List<AsistenciaAlumno> asistenciaAlumnoList;

    public FormAsistenciaAlumno() {
    }

    public List<AsistenciaAlumno> getAsistenciaAlumnoList() {
        return asistenciaAlumnoList;
    }

    public void setAsistenciaAlumnoList(AsistenciaAlumno a) {
        asistenciaAlumnoList.add(a);
    }

    public AsistenciaAlumno getAsistenciaAlumnoList(int id) {
        return asistenciaAlumnoList.get(id);
    }

    public void setAsistenciaAlumnoList(List<AsistenciaAlumno> asistenciaAlumnoList) {
        this.asistenciaAlumnoList = asistenciaAlumnoList;
    }

    @Override
    public String toString() {
        return "FormAsistenciaAlumno{" +
                "asistenciaAlumnoList=" + asistenciaAlumnoList +
                '}';
    }

}
