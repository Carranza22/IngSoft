package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Docente;
import net.cyancj.sistemae_cepuns.service.IDocenteService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    private final IDocenteService docenteService;

    public DocenteController(IDocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping("/registrar")
    public String registrarDocente(@Valid @ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (!docenteService.searchByDni(docente.getDni())) {
                docenteService.add(docente);
                json.setMessage("Docente registrado correctamente");
                json.success();
            } else {
                json.setMessage("Existe un registro");
            }
        } else {
            json.setMessage("Ocurrió un error.");
        }

        return json.getJson();
    }
}
