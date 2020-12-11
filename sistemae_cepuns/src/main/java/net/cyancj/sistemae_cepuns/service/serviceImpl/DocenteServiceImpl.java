package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Docente;
import net.cyancj.sistemae_cepuns.repository.DocenteRepository;
import net.cyancj.sistemae_cepuns.service.IDocenteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImpl implements IDocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public Docente add(Docente docente) {
        return docenteRepository.saveAndFlush(docente);
    }

    @Override
    public List<Docente> listAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente search(String dni) {
        Optional<Docente> search = docenteRepository.findById(dni);
        return search.orElse(null);
    }

    @Override
    public boolean update(Docente docente) {
        try {
            docenteRepository.save(docente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String dni) {
        try {
            docenteRepository.deleteById(dni);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Docente docente) {
        for (Docente d : listAll()) {
            if (d.getDni().equals(docente.getDni()) && d.getNombres().equals(docente.getNombres()) && d.getApellidos().equals(docente.getApellidos())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean searchByDni(String dni) {
        for (Docente d : listAll()) {
            if (d.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }
}
