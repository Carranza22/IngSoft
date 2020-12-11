package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.Nota;

public interface INotaService extends IGenericService<Nota, Long> {
    boolean searchForTipoCicloFacultad(String tipo, Long id_ciclo, Long id_facultad);

    Double getNotaForMatriculaTipoNota(Long id_matricula, String tipo_nota);
}
