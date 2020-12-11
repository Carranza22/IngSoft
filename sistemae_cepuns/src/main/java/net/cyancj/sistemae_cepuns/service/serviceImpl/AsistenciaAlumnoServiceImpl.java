package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.AsistenciaAlumno;
import net.cyancj.sistemae_cepuns.entity.AsistenciaDocente;
import net.cyancj.sistemae_cepuns.repository.AsistenciaAlumnoRepository;
import net.cyancj.sistemae_cepuns.repository.MatriculaRepository;
import net.cyancj.sistemae_cepuns.service.IAsistenciaAlumnoService;
import net.cyancj.sistemae_cepuns.service.IMatriculaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaAlumnoServiceImpl implements IAsistenciaAlumnoService {

    private final AsistenciaAlumnoRepository asistenciaAlumnoRepository;
    private final IMatriculaService matriculaService;

    public AsistenciaAlumnoServiceImpl(AsistenciaAlumnoRepository asistenciaAlumnoRepository, IMatriculaService matriculaService) {
        this.asistenciaAlumnoRepository = asistenciaAlumnoRepository;
        this.matriculaService = matriculaService;
    }

    @Override
    public AsistenciaAlumno add(AsistenciaAlumno asistenciaAlumno) {
        return asistenciaAlumnoRepository.saveAndFlush(asistenciaAlumno);
    }

    @Override
    public List<AsistenciaAlumno> listAll() {
        return asistenciaAlumnoRepository.findAll();
    }

    @Override
    public AsistenciaAlumno search(Long id) {
        Optional<AsistenciaAlumno> search = asistenciaAlumnoRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(AsistenciaAlumno asistenciaAlumno) {
        try {
            asistenciaAlumnoRepository.save(asistenciaAlumno);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            asistenciaAlumnoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(AsistenciaAlumno asistenciaAlumno) {
        for (AsistenciaAlumno a : listAll()) {
            if (a.getAsistencia().getFecha().getTime() == asistenciaAlumno.getAsistencia().getFecha().getTime() &&
                    a.getMatricula().getAlumno().getDni().equals(asistenciaAlumno.getMatricula().getAlumno().getDni())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkAsistenciaForFechaCicloFacultad(Date date, Long idCiclo, Long idFacultad) {
        if (listAll().size() > 0) {
            for (AsistenciaAlumno a : listAll()) {
                if (a.getAsistencia().getFecha().getTime() == date.getTime() &&
                        a.getAsistencia().getCiclo().getId().equals(idCiclo) &&
                        matriculaService.getFacultadForDniCiclo(a.getMatricula().getAlumno().getDni(), idCiclo).equals(idFacultad)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<AsistenciaAlumno> listAsistenciaForCicloDnI(Long id_ciclo, String alumno_dni) {
        List<AsistenciaAlumno> listAsistencia = new ArrayList<>();
        for (AsistenciaAlumno a : listAll()) {
            if (a.getMatricula().getCiclo().getId().equals(id_ciclo) && a.getMatricula().getAlumno().getDni().equals(alumno_dni)) {
                listAsistencia.add(a);
            }
        }
        return listAsistencia;
    }
}
