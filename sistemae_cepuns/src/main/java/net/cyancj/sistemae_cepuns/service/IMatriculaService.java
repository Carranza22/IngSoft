package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.Alumno;
import net.cyancj.sistemae_cepuns.entity.Matricula;

import java.util.List;

public interface IMatriculaService extends IGenericService<Matricula, Long> {
    List<Matricula> listCiclo(Long id);

    List<Matricula> listAlumno(String dni);

    List<Matricula> getForCicloFacultad(Long id_ciclo, Long id_facultad);

    List<Alumno> getAlumnosForCicloFacultad(Long id_ciclo, Long id_facultad);

    Long getFacultadForDniCiclo(String dni, Long id_ciclo);

    List<Alumno> getAlumnosForCiclo(Long id_ciclo);

    List<Matricula> getMatriculasForCiclo(Long id_ciclo);
}
