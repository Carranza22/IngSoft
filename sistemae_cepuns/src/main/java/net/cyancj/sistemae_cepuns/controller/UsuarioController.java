package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Usuario;
import net.cyancj.sistemae_cepuns.service.IUsuarioService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    public IUsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(IUsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/registro/{id}")
    public Usuario registroAdministrador(@PathVariable("id") Long id) {
        return usuarioService.searchAdminById(id);
    }

    @PostMapping("/admin/registrar")
    public String registrarUsuario(@Valid @ModelAttribute("administrador") Usuario usuario, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (usuarioService.searchByName(usuario)) {
                json.setMessage("El administrador existe");
            } else {
                usuario.setAdmin(true);
                usuarioService.add(usuario);
                json.setMessage("Administrador registrado exitosamente");
                json.success();
            }
        }
        return json.getJson();
    }

    @PostMapping("/admin/editar")
    public String editarAdministrador(@Valid @ModelAttribute("administrador") Usuario usuario, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            Usuario admin = usuarioService.searchAdminById(usuario.getId());
            if (admin != null) {
                if (!usuario.getClave().equals("none")) {
                    admin.setClave(passwordEncoder.encode(usuario.getClave()));
                }
                admin.setNombres(usuario.getNombres());
                admin.setApellidos(usuario.getApellidos());
                admin.setUsuario(usuario.getUsuario());
                admin.setRol(usuario.getRol());
                if (usuarioService.update(admin)) {
                    json.setMessage("Se actualizó exitosamente");
                    json.success();
                } else {
                    json.setMessage("Ocurrió un error al guardar");
                }
            } else {
                json.setMessage("El administrador no existe");
            }
        } else {
            json.setMessage("Ocurrió un error");
        }
        return json.getJson();
    }

    @PostMapping("/admin/eliminar")
    public String eliminarAdministrador(@RequestParam("id") Long id) {
        JsonResponse json = new JsonResponse();
        if (usuarioService.delete(id)) {
            json.setMessage("Se eliminó correctamente");
            json.success();
        } else {
            json.setMessage("No se pudo eliminar");
        }
        return json.getJson();
    }
}
