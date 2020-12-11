package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.AsistenciaAlumno;

import java.util.Date;
import java.util.List;

public interface IAsistenciaAlumnoService extends IGenericService<AsistenciaAlumno, Long> {
    boolean checkAsistenciaForFechaCicloFacultad(Date date, Long idCiclo, Long idFacultad);

    List<AsistenciaAlumno> listAsistenciaForCicloDnI(Long id_ciclo, String alumno_dni);
}
