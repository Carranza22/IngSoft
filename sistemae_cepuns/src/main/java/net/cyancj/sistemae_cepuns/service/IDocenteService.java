package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.Docente;

public interface IDocenteService extends IGenericService<Docente, String> {
    boolean searchByDni(String dni);
}
