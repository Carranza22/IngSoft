package net.cyancj.sistemae_cepuns.service;

import net.cyancj.sistemae_cepuns.entity.Usuario;

import java.util.List;

public interface IUsuarioService extends IGenericService<Usuario, Long> {
    List<Usuario> listAdministradores();

    Usuario searchAdminById(Long id);
}
