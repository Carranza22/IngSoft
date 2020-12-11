package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Carrera;
import net.cyancj.sistemae_cepuns.entity.Facultad;
import net.cyancj.sistemae_cepuns.service.IFacultadService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facultad")
public class FacultadController {
    public IFacultadService facultadService;

    public FacultadController(IFacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping("/registro/{id}")
    public Facultad registroFacultad(@PathVariable("id") Long id) {
        return facultadService.search(id);
    }

    @GetMapping("/registro/{id}/carreras")
    public List<Carrera> listaCarreras(@PathVariable("id") Long id) {
        Facultad facultad = facultadService.search(id);
        if(facultad != null){
            return facultadService.search(id).getCarreras();
        }
        return null;
    }

    @PostMapping("/registrar")
    public String registrarFacultad(@Valid @ModelAttribute("facultad") Facultad facultad, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (facultadService.searchByName(facultad)) {
                json.setMessage("La facultad existe");
            } else {
                facultadService.add(facultad);
                json.setMessage("Facultad registrado exitosamente");
                json.success();
            }
        }
        return json.getJson();
    }

    @PostMapping("/editar")
    public String editarFacultad(@Valid @ModelAttribute("facultad") Facultad facultad, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (facultadService.update(facultad)) {
                json.setMessage("Se guardó correctamente.");
                json.success();
            } else {
                json.setMessage("No se pudo guardar.");
            }
        } else {
            json.setMessage("Ocurrió un error.");
        }

        return json.getJson();
    }

    @PostMapping("/eliminar")
    public String eliminarFacultad(@RequestParam("id") Long id) {
        JsonResponse json = new JsonResponse();
        if (facultadService.delete(id)) {
            json.setMessage("Se eliminó correctamente");
            json.success();
        } else {
            json.setMessage("No se pudo eliminar");
        }
        return json.getJson();
    }
}
