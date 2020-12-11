package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Usuario;
import net.cyancj.sistemae_cepuns.repository.UsuarioRepository;
import net.cyancj.sistemae_cepuns.service.IUsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario add(Usuario usuario) {
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        usuario.setEstado(1);
        return usuarioRepository.saveAndFlush(usuario);
    }

    @Override
    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario search(Long id) {
        Optional<Usuario> search = usuarioRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Usuario usuario) {
        return false;
    }

    @Override
    public List<Usuario> listAdministradores() {
        List<Usuario> list = new ArrayList<>();
        for (Usuario usuario : listAll()) {
            if (usuario.getAdmin()) {
                list.add(usuario);
            }
        }
        return list;
    }

    @Override
    public Usuario searchAdminById(Long id) {
        Optional<Usuario> search = usuarioRepository.findById(id);
        if (search.isPresent()) {
            if (search.get().getAdmin()) {
                return search.get();
            }
            return null;
        }
        return null;
    }
}
