package net.cyancj.sistemae_cepuns.controller;

import net.cyancj.sistemae_cepuns.entity.*;
import net.cyancj.sistemae_cepuns.service.*;
import net.cyancj.sistemae_cepuns.utils.FormAsistenciaAlumno;
import net.cyancj.sistemae_cepuns.utils.FormNotaAlumno;
import net.cyancj.sistemae_cepuns.utils.NotaAlumno;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    private final IFacultadService facultadService;
    private final ICarreraService carreraService;
    private final IUsuarioService usuarioService;
    private final ICicloService cicloService;
    private final IMatriculaService matriculaService;
    private final IAlumnoService alumnoService;
    private final IDocenteService docenteService;
    private final IAsistenciaService asistenciaService;
    private final IAsistenciaAlumnoService asistenciaAlumnoService;
    private final IAsistenciaDocenteService asistenciaDocenteService;
    private final INotaService notaService;

    public AdministradorController(IFacultadService facultadService, ICarreraService carreraService, IUsuarioService usuarioService, ICicloService cicloService, IMatriculaService matriculaService, IAlumnoService alumnoService, IDocenteService docenteService, IAsistenciaService asistenciaService, IAsistenciaAlumnoService asistenciaAlumnoService, IAsistenciaDocenteService asistenciaDocenteService, INotaService notaService) {
        this.facultadService = facultadService;
        this.carreraService = carreraService;
        this.usuarioService = usuarioService;
        this.cicloService = cicloService;
        this.matriculaService = matriculaService;
        this.alumnoService = alumnoService;
        this.docenteService = docenteService;
        this.asistenciaService = asistenciaService;
        this.asistenciaAlumnoService = asistenciaAlumnoService;
        this.asistenciaDocenteService = asistenciaDocenteService;
        this.notaService = notaService;
    }

    @GetMapping("/")
    public String index(Model model, Authentication auth) {
        String rol = auth.getAuthorities().toString();
        System.out.println(rol);
        model.addAttribute("privilegio", rol);
        return "administracion/panel";
    }

    @GetMapping("/general")
    public String general(Model model) {
        model.addAttribute("titulo_container", "GENERAL");
        return "administracion/general/index";
    }

    @GetMapping("/general/administradores")
    public String sectionAdministradores(Model model) {
        model.addAttribute("administrador", new Usuario());
        return "administracion/general/administradores";
    }

    @GetMapping("/general/carreras_facultades")
    public String sectionCarrerasFacultades(Model model) {
        model.addAttribute("facultad", new Facultad());
        model.addAttribute("carrera", new Carrera());
        model.addAttribute("facultades", facultadService.listAll());
        model.addAttribute("carreras", carreraService.listAll());
        return "administracion/general/carreras_facultades";
    }

    @GetMapping("/general/matriculas")
    public String sectionMatriculas(Model model) {
        model.addAttribute("ciclo", new Ciclo());
        model.addAttribute("inscripciones", cicloService.inscripcionesHabilitadas());
        return "administracion/general/matriculas";
    }

    @GetMapping("/lista/usuarios")
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listAdministradores());
        return "administracion/general/lista_administrador";
    }


    @GetMapping("/lista/facultades")
    public String listaFacultades(Model model) {
        model.addAttribute("facultades", facultadService.listAll());
        return "administracion/general/lista_facultades";
    }

    @GetMapping("/lista/carreras")
    public String listaCarreras(Model model) {
        model.addAttribute("carreras", carreraService.listAll());
        return "administracion/general/lista_carreras";
    }

    @GetMapping("/lista/ciclos")
    public String listaCiclos(Model model) {
        model.addAttribute("ciclos", cicloService.listAll());
        return "administracion/general/lista_ciclos";
    }

    @GetMapping("/matricula")
    public String matricula(Model model) {
        model.addAttribute("titulo_container", "MATRÍCULA");
        model.addAttribute("lista_ciclos", cicloService.listAll());
        return "administracion/matricula/index";
    }

    @GetMapping("/matricula/lista/general")
    public String matriculaListaGeneral(Model model) {
        model.addAttribute("matriculas", matriculaService.listAll());
        return "administracion/matricula/lista_general";
    }

    @GetMapping("/matricula/lista/ciclo/{id}")
    public String matriculaListaCiclo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("matriculas", matriculaService.listCiclo(id));
        return "administracion/matricula/lista_ciclo";
    }

    @GetMapping("/matricula/lista/alumno/{dni}")
    public String matriculaListaAlumno(@PathVariable("dni") String dni, Model model) {
        List<Matricula> resultado = matriculaService.listAlumno(dni);
        model.addAttribute("matriculas", resultado);
        model.addAttribute("resultado", resultado.size() > 0);
        return "administracion/matricula/lista_alumno";
    }

    @GetMapping("/matricula/registrar")
    public String registrarMatricula(Model model) {
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("facultades", facultadService.listAll());
        model.addAttribute("matriculas_habilitadas", cicloService.inscripcionesHabilitadas());
        model.addAttribute("ciclo_insc", cicloService.inscripcionHabilitada());
        return "administracion/matricula/registrar";
    }

    @GetMapping("/alumno")
    public String alumno(Model model) {
        model.addAttribute("titulo_container", "ALUMNO");
        model.addAttribute("alumnos", alumnoService.listAll());
        return "administracion/alumno/index";
    }

    @GetMapping("/alumno/registrar")
    public String registrarAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "administracion/alumno/registrar";
    }

    @GetMapping("/docente")
    public String docente(Model model) {
        model.addAttribute("titulo_container", "DOCENTE");
        model.addAttribute("docentes", docenteService.listAll());
        return "administracion/docente/index";
    }

    @GetMapping("/docente/registrar")
    public String registrarDocente(Model model) {
        model.addAttribute("docente", new Docente());
        return "administracion/docente/registrar";
    }

    @GetMapping("/asistencia")
    public String asistencia(Model model) {
        model.addAttribute("titulo_container", "ASISTENCIA");
        model.addAttribute("id_ciclo", cicloService.idUltimaInscripcion());
        model.addAttribute("facultades", facultadService.listAll());
        model.addAttribute("lista_ciclos", cicloService.listAll());
        return "administracion/asistencia/index";
    }

    @GetMapping("/asistencia/registrar/alumnos/{id_ciclo}/{fecha}/{id_facultad}")
    public String registrarAsistenciaAlumnos(@PathVariable("id_ciclo") Long id_ciclo,
                                             @PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
                                             @PathVariable("id_facultad") Long id_facultad, Model model) {
        if (asistenciaService.getForFechaCiclo(fecha, id_ciclo) == null) {
            Asistencia nAsistencia = new Asistencia();
            nAsistencia.setCiclo(cicloService.search(id_ciclo));
            nAsistencia.setFecha(fecha);
            asistenciaService.add(nAsistencia);
        }
        if (!asistenciaAlumnoService.checkAsistenciaForFechaCicloFacultad(fecha, id_ciclo, id_facultad)) {
            Asistencia asistencia = asistenciaService.getForFechaCiclo(fecha, id_ciclo);
            List<Matricula> listMatricula = matriculaService.getForCicloFacultad(id_ciclo, id_facultad);
            List<AsistenciaAlumno> listAsistenciaAlumnos = new ArrayList<>();
            listMatricula.forEach(matriculaAlumno -> {
                AsistenciaAlumno a = new AsistenciaAlumno();
                a.setMatricula(matriculaAlumno);
                a.setAsistencia(asistencia);
                a.setCheck_asistencia(false);
                listAsistenciaAlumnos.add(a);
            });
            FormAsistenciaAlumno formAsistenciaAlumno = new FormAsistenciaAlumno();
            formAsistenciaAlumno.setAsistenciaAlumnoList(listAsistenciaAlumnos);
            model.addAttribute("list_alumnos", formAsistenciaAlumno);
            model.addAttribute("lista_activa", true);
        } else {
            model.addAttribute("lista_activa", false);
        }
        return "administracion/asistencia/registrar_alumnos";
    }

    @GetMapping("/asistencia/registro/ciclo/{id_ciclo}")
    public String registroAsistencia(@PathVariable("id_ciclo") Long id_ciclo, Model model) {
        model.addAttribute("id_ciclo", id_ciclo);
        model.addAttribute("lista_alumnos", matriculaService.getAlumnosForCiclo(id_ciclo));
        model.addAttribute("lista_docentes", docenteService.listAll());
        return "administracion/asistencia/lista_asistencia";
    }

    @GetMapping("/asistencia/registro/alumno/{dni_alumno}/ciclo/{id_ciclo}")
    public String registroAsistenciaAlumno(@PathVariable("dni_alumno") String dni_alumno, @PathVariable("id_ciclo") Long id_ciclo, Model model) {
        model.addAttribute("alumno", alumnoService.search(dni_alumno));
        model.addAttribute("ciclo", cicloService.search(id_ciclo));
        model.addAttribute("asistencias", asistenciaAlumnoService.listAsistenciaForCicloDnI(id_ciclo, dni_alumno));
        return "administracion/asistencia/lista_asistencia_alumno";
    }

    @GetMapping("/asistencia/registro/docente/{dni_docente}/ciclo/{id_ciclo}")
    public String registroAsistenciaDocente(@PathVariable("dni_docente") String dni_docente, @PathVariable("id_ciclo") Long id_ciclo, Model model) {
        model.addAttribute("docente", docenteService.search(dni_docente));
        model.addAttribute("ciclo", cicloService.search(id_ciclo));
        model.addAttribute("asistencias", asistenciaDocenteService.listAsistenciaForCicloDnI(id_ciclo, dni_docente));
        return "administracion/asistencia/lista_asistencia_docente";
    }


    @GetMapping("/notas")
    public String notas(Model model) {
        model.addAttribute("titulo_container", "NOTAS");
        model.addAttribute("id_ciclo", cicloService.idUltimaInscripcion());
        model.addAttribute("facultades", facultadService.listAll());
        model.addAttribute("lista_ciclos", cicloService.listAll());
        return "administracion/notas/index";
    }

    @GetMapping("/notas/registrar/alumnos/{tipo_nota}/{id_ciclo}/{id_facultad}")
    public String registrarNotasAlumnos(@PathVariable("tipo_nota") String tipo_nota, @PathVariable("id_ciclo") Long id_ciclo, @PathVariable("id_facultad") Long id_facultad, Model model) {
        if (notaService.searchForTipoCicloFacultad(tipo_nota, id_ciclo, id_facultad)) {
            model.addAttribute("lista_activa", false);
        } else {
            List<Nota> listNotas = new ArrayList<>();
            List<Matricula> listMatricula = matriculaService.getForCicloFacultad(id_ciclo, id_facultad);
            listMatricula.forEach(matricula -> {
                Nota n = new Nota();
                n.setTipo(tipo_nota);
                n.setMatricula(matricula);
                n.setNota(0.000);
                listNotas.add(n);
            });
            FormNotaAlumno formNotaAlumno = new FormNotaAlumno();
            formNotaAlumno.setNotaList(listNotas);
            model.addAttribute("lista_activa", true);
            model.addAttribute("list_alumnos", formNotaAlumno);
        }
        return "administracion/notas/registrar_alumno";
    }

    @GetMapping("/notas/registro/ciclo/{id_ciclo}")
    public String registroNotasAlumnos(@PathVariable("id_ciclo") Long id_ciclo, Model model) {
        List<NotaAlumno> listaNotas = new ArrayList<>();
        matriculaService.getMatriculasForCiclo(id_ciclo).forEach(matricula -> {
            NotaAlumno notaAlumno = new NotaAlumno();
            notaAlumno.setAlumno(matricula.getAlumno());
            notaAlumno.setNota1(notaService.getNotaForMatriculaTipoNota(matricula.getId(), "sumativo1"));
            notaAlumno.setNota2(notaService.getNotaForMatriculaTipoNota(matricula.getId(), "sumativo2"));
            notaAlumno.setNota3(notaService.getNotaForMatriculaTipoNota(matricula.getId(), "sumativo3"));
            listaNotas.add(notaAlumno);
            System.out.println(notaAlumno.toString());
        });
        model.addAttribute("registro_notas", listaNotas);
        return "administracion/notas/lista_nota";
    }
}
