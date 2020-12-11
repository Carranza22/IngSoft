package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.Alumno;
import net.cyancj.sistemae_cepuns.entity.Matricula;
import net.cyancj.sistemae_cepuns.service.IAlumnoService;
import net.cyancj.sistemae_cepuns.service.IMatriculaService;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    public IMatriculaService matriculaService;
    public IAlumnoService alumnoService;

    public MatriculaController(IMatriculaService matriculaService, IAlumnoService alumnoService) {
        this.matriculaService = matriculaService;
        this.alumnoService = alumnoService;
    }

    @PostMapping("/registrar")
    public String registrarMatricula(@Valid @ModelAttribute("matricula") Matricula matricula, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (!matriculaService.searchByName(matricula)) {
                Alumno alumno = matricula.getAlumno();
                if (!alumnoService.searchByName(alumno)) {
                    alumnoService.add(alumno);
                }
                matriculaService.add(matricula);
                json.setMessage("Matricula registrado exitosamente");
                json.success();
            } else {
                json.setMessage("Existe una matricula registrada");
            }
        } else {
            json.setMessage("Ocurrió un error");
        }

        return json.getJson();
    }
}
