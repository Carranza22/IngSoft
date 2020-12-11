package net.cyancj.sistemae_cepuns.controller;


import net.cyancj.sistemae_cepuns.entity.Asistencia;
import net.cyancj.sistemae_cepuns.entity.AsistenciaDocente;
import net.cyancj.sistemae_cepuns.service.IAsistenciaAlumnoService;
import net.cyancj.sistemae_cepuns.service.IAsistenciaDocenteService;
import net.cyancj.sistemae_cepuns.service.IAsistenciaService;
import net.cyancj.sistemae_cepuns.service.IDocenteService;
import net.cyancj.sistemae_cepuns.utils.FormAsistenciaAlumno;
import net.cyancj.sistemae_cepuns.utils.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    private final IDocenteService docenteService;
    private final IAsistenciaService asistenciaService;
    private final IAsistenciaAlumnoService asistenciaAlumnoService;
    private final IAsistenciaDocenteService asistenciaDocenteService;

    public AsistenciaController(IDocenteService docenteService, IAsistenciaService asistenciaService, IAsistenciaAlumnoService asistenciaAlumnoService, IAsistenciaDocenteService asistenciaDocenteService) {
        this.docenteService = docenteService;
        this.asistenciaService = asistenciaService;
        this.asistenciaAlumnoService = asistenciaAlumnoService;
        this.asistenciaDocenteService = asistenciaDocenteService;
    }

    @PostMapping("/registrar/docente")
    public String registrarAsistenciaDocente(@Valid @ModelAttribute("asistenciaDocente") AsistenciaDocente asistenciaDocente, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            if (docenteService.searchByDni(asistenciaDocente.getDocente().getDni())) {
                Date fechaPost = asistenciaDocente.getAsistencia().getFecha();
                Long idCicloPost = asistenciaDocente.getAsistencia().getCiclo().getId();
                if (!asistenciaService.searchByDate(fechaPost, idCicloPost)) {
                    //Asistencia no esta registrada
                    asistenciaService.add(asistenciaDocente.getAsistencia()); // Se añade la asistencia a la DB
                }
                Asistencia asistencia = asistenciaService.getForFechaCiclo(fechaPost, idCicloPost); //Obtenemos el id la fecha registrada con los datos requeridos
                if (asistencia != null) {
                    if (asistenciaDocenteService.searchForDniIdAsistencia(asistenciaDocente.getDocente().getDni(), asistencia.getId())) {
                        json.setMessage("Registro existe");
                    } else {
                        asistenciaDocente.setAsistencia(asistencia);
                        asistenciaDocenteService.add(asistenciaDocente);
                        json.setMessage("Se registró correctamente");
                        json.success();
                    }
                } else {
                    json.setMessage("Ocurrió un error..");
                }
            } else {
                json.setMessage("El docente no existe");
            }
        } else {
            json.setMessage("Ocurrió un error.");
        }
        return json.getJson();
    }


    @PostMapping("/registrar/alumnos")
    public String registrarAsistenciaAlumnos(@Valid @ModelAttribute("listaAsistencia") FormAsistenciaAlumno listaAsistencia, BindingResult bindingResult) {
        JsonResponse json = new JsonResponse();
        if (!bindingResult.hasErrors()) {
            listaAsistencia.getAsistenciaAlumnoList().forEach(asistenciaAlumnoService::add);
            json.setMessage("Se registró correctamente");
            json.success();
        } else {
            json.setMessage("Ocurrió un error.");
        }
        return json.getJson();
    }
}
