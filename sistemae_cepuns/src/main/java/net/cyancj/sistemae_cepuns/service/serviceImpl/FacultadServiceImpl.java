package net.cyancj.sistemae_cepuns.service.serviceImpl;

import org.springframework.stereotype.Service;
import net.cyancj.sistemae_cepuns.entity.Facultad;
import net.cyancj.sistemae_cepuns.repository.FacultadRepository;
import net.cyancj.sistemae_cepuns.service.IFacultadService;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadServiceImpl implements IFacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadServiceImpl(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @Override
    public Facultad add(Facultad facultad) {
        return facultadRepository.saveAndFlush(facultad);
    }

    @Override
    public List<Facultad> listAll() {
        return facultadRepository.findAll();
    }

    @Override
    public Facultad search(Long id) {
        Optional<Facultad> search = facultadRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(Facultad facultad) {
        try {
            facultadRepository.save(facultad);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            facultadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Facultad facultad) {
        boolean result = false;
        for (Facultad a : listAll()) {
            if (a.getNombre_facultad().equals(facultad.getNombre_facultad())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
