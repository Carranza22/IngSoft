package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.service.INotaService;
import net.cyancj.sistemae_cepuns.utils.FormNotaAlumno;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notas")
public class NotaController {
    private final INotaService notaService;

    public NotaController(INotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping("/registrar")
    public String registrarNotas(@Valid @ModelAttribute("listaNota") FormNotaAlumno listaNota, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            listaNota.getNotaList().forEach(notaService::add);
            json.setMessage("Se registró correctamente");
            json.success();
        } else {
            json.setMessage("Ocurrió un error.");
        }
        return json.getJson();
    }
}
