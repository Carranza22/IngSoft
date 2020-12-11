package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.Ciclo;

public interface ICicloService extends IGenericService<Ciclo, Long> {
    boolean inscripcionesHabilitadas();

    Ciclo inscripcionHabilitada();

    Long idUltimaInscripcion();
}
