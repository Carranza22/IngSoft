package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.AsistenciaDocente;

import java.util.List;

public interface IAsistenciaDocenteService extends IGenericService<AsistenciaDocente, Long> {
    boolean searchForDniIdAsistencia(String dni, Long idAsistencia);

    List<AsistenciaDocente> listAsistenciaForCicloDnI(Long id_ciclo, String dni);
}
