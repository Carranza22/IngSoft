package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Alumno;
import net.cyancj.sistemae_cepuns.service.IAlumnoService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final IAlumnoService alumnoService;

    public AlumnoController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/registro/{dni}")
    public Alumno registroAlumno(@PathVariable("dni") String dni) {
        return alumnoService.search(dni);
    }

    @PostMapping("/registrar")
    public String registrarAlumno(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (!alumnoService.searchByName(alumno)) {
                alumnoService.add(alumno);
                json.setMessage("Alumno registrado correctamente");
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
