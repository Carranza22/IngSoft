package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Alumno;
import net.cyancj.sistemae_cepuns.repository.AlumnoRepository;
import net.cyancj.sistemae_cepuns.service.IAlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Alumno add(Alumno alumno) {
        return alumnoRepository.saveAndFlush(alumno);
    }

    @Override
    public List<Alumno> listAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno search(String dni) {
        Optional<Alumno> search = alumnoRepository.findById(dni);
        return search.orElse(null);
    }

    @Override
    public boolean update(Alumno alumno) {
        try {
            alumnoRepository.save(alumno);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String dni) {
        try {
            alumnoRepository.deleteById(dni);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Alumno alumno) {
        for (Alumno a : listAll()) {
            if (a.getDni().equals(alumno.getDni())) {
                return true;
            }
        }
        return false;
    }

}
