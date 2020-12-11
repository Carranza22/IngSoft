package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Carrera;
import net.cyancj.sistemae_cepuns.service.ICarreraService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    public ICarreraService carreraService;

    public CarreraController(ICarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping("/registro/{id}")
    public Carrera registroCarrera(@PathVariable("id") Long id) {
        return carreraService.search(id);
    }

    @PostMapping("/registrar")
    public String registrarCarrera(@Valid @ModelAttribute("carrera") Carrera carrera, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (carreraService.searchByName(carrera)) {
                json.setMessage("La Carrera Profesional existe");
            } else {
                carreraService.add(carrera);
                json.setMessage("Carrera registrado exitosamente");
                json.success();
            }
        }
        return json.getJson();
    }

    @PostMapping("/editar")
    public String editarCarrera(@Valid @ModelAttribute("carrera") Carrera carrera, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (carreraService.update(carrera)) {
                json.setMessage("Se guardó correctamente..");
                json.success();
            } else {
                json.setMessage("No se pudo guardar..");
            }
        } else {
            json.setMessage("Ocurrió un error..");
        }

        return json.getJson();
    }

    @PostMapping("/eliminar")
    public String eliminarCarrera(@RequestParam("id") Long id) {
        JsonResponse json = new JsonResponse();
        if (carreraService.delete(id)) {
            json.setMessage("Se eliminó correctamente");
            json.success();
        } else {
            json.setMessage("No se pudo eliminar");
        }
        return json.getJson();
    }
}
