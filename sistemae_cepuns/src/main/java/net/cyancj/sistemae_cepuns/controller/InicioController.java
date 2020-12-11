package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.service.IUsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class InicioController {

    @GetMapping("/")
    public String index(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model, Authentication auth) {

        if (error != null) {
            model.addAttribute("error", "Usuario y contraseña incorrecta");
        }

        if (logout != null) {
            model.addAttribute("logout", "Sesión cerrada");
        }

        try {
            String rol = auth.getAuthorities().toString();
            if (rol.contains("ADMINISTRADOR") || rol.contains("ASISTENCIA") || rol.contains("MATRICULA") || rol.contains("NOTAS")) {
                return "redirect:/administrador/";
            }
        } catch (Exception ignored) {

        }
        return "login";
    }

    @GetMapping("/success")
    public String controlRoles(Authentication auth) {
        try {
            String rol = auth.getAuthorities().toString();

            if (rol.contains("ADMINISTRADOR") || rol.contains("ASISTENCIA") || rol.contains("MATRICULA") || rol.contains("NOTAS") ) {
                return "redirect:/administrador/";
            }
        } catch (Exception ignored) {

        }
        return "redirect:/";
    }

}
