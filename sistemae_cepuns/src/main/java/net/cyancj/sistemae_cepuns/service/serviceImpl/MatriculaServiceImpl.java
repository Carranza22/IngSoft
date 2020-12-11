package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Alumno;
import net.cyancj.sistemae_cepuns.entity.Matricula;
import net.cyancj.sistemae_cepuns.repository.MatriculaRepository;
import net.cyancj.sistemae_cepuns.service.IMatriculaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public Matricula add(Matricula matricula) {
        return matriculaRepository.saveAndFlush(matricula);
    }

    @Override
    public List<Matricula> listAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula search(Long id) {
        Optional<Matricula> search = matriculaRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(Matricula matricula) {
        try {
            matriculaRepository.save(matricula);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            matriculaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Matricula matricula) {
        for (Matricula m : listAll()) {
            if (matricula.getAlumno().getDni().equals(m.getAlumno().getDni()) && matricula.getCiclo().getId().equals(m.getCiclo().getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Matricula> listCiclo(Long id) {
        List<Matricula> listCiclo = new ArrayList<>();
        for (Matricula matricula : listAll()) {
            if (matricula.getCiclo().getId().equals(id)) {
                listCiclo.add(matricula);
            }
        }
        return listCiclo;
    }

    @Override
    public List<Matricula> listAlumno(String dni) {
        List<Matricula> listAlumno = new ArrayList<>();
        for (Matricula matricula : listAll()) {
            if (matricula.getAlumno().getDni().equals(dni)) {
                listAlumno.add(matricula);
            }
        }
        return listAlumno;
    }


    @Override
    public List<Matricula> getForCicloFacultad(Long id_ciclo, Long id_facultad) {
        List<Matricula> listMatricula = new ArrayList<>();
        for (Matricula m : listAll()) {
            if (m.getCiclo().getId().equals(id_ciclo) && m.getCarrera().getFacultad().getId().equals(id_facultad)) {
                listMatricula.add(m);
            }
        }
        return listMatricula;
    }

    @Override
    public List<Alumno> getAlumnosForCicloFacultad(Long id_ciclo, Long id_facultad) {
        List<Alumno> listAlumno = new ArrayList<>();
        for (Matricula m : listAll()) {
            if (m.getCiclo().getId().equals(id_ciclo) && m.getCarrera().getFacultad().getId().equals(id_facultad)) {
                listAlumno.add(m.getAlumno());
            }
        }
        return listAlumno;
    }

    @Override
    public Long getFacultadForDniCiclo(String dni, Long id_ciclo) {
        for (Matricula m : listAll()) {
            if (m.getAlumno().getDni().equals(dni) && m.getCiclo().getId().equals(id_ciclo)) {
                return m.getCarrera().getFacultad().getId();
            }
        }
        return null;
    }

    @Override
    public List<Alumno> getAlumnosForCiclo(Long id_ciclo) {
        List<Alumno> listAlumno = new ArrayList<>();
        for (Matricula m : listAll()) {
            if (m.getCiclo().getId().equals(id_ciclo)) {
                listAlumno.add(m.getAlumno());
            }
        }
        return listAlumno;
    }

    @Override
    public List<Matricula> getMatriculasForCiclo(Long id_ciclo) {
        List<Matricula> lisMatriculas = new ArrayList<>();
        for (Matricula m : listAll()) {
            if (m.getCiclo().getId().equals(id_ciclo)) {
                lisMatriculas.add(m);
            }
        }
        return lisMatriculas;
    }
}
