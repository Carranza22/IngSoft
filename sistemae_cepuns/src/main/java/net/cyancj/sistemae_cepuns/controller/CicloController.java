package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Ciclo;
import net.cyancj.sistemae_cepuns.service.ICicloService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ciclo")
public class CicloController {

    public ICicloService cicloService;

    public CicloController(ICicloService cicloService) {
        this.cicloService = cicloService;
    }

    @GetMapping("/registro/{id}")
    public Ciclo registroCiclo(@PathVariable("id") Long id) {
        return cicloService.search(id);
    }

    @PostMapping("/registrar")
    public String registrarCiclo(@Valid @ModelAttribute("ciclo") Ciclo ciclo, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (cicloService.searchByName(ciclo)) {
                json.setMessage("El ciclo de Estudio existe");
            } else {
                cicloService.add(ciclo);
                json.setMessage("Ciclo de Estudio registrado exitosamente");
                json.success();
            }
        } else {
            json.setMessage("Ocurrió un error");
        }
        return json.getJson();
    }

    @PostMapping("/editar")
    public String editarCiclo(@Valid @ModelAttribute("ciclo") Ciclo ciclo, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (cicloService.update(ciclo)) {
                json.setMessage("Se guardó correctamente");
                json.success();
            } else {
                json.setMessage("No se pudo guardar");
            }
        } else {
            json.setMessage("Ocurrió un error");
        }

        return json.getJson();
    }

    @PostMapping("/eliminar")
    public String eliminarCiclo(@RequestParam("id") Long id) {
        JsonResponse json = new JsonResponse();
        if (cicloService.delete(id)) {
            json.setMessage("Se eliminó correctamente");
            json.success();
        } else {
            json.setMessage("No se pudo eliminar");
        }
        return json.getJson();
    }
}
