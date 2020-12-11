package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.Asistencia;

import java.util.Date;


public interface IAsistenciaService extends IGenericService<Asistencia, Long> {
    boolean searchByDate(Date date, Long idCiclo);

    Asistencia getForFechaCiclo(Date date, Long idCiclo);
}
