package net.cyancj.sistemae_cepuns.service.serviceImpl;

import org.springframework.stereotype.Service;
import net.cyancj.sistemae_cepuns.entity.Carrera;
import net.cyancj.sistemae_cepuns.repository.CarreraRepository;
import net.cyancj.sistemae_cepuns.service.ICarreraService;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements ICarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraServiceImpl(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    @Override
    public Carrera add(Carrera carrera) {
        return carreraRepository.saveAndFlush(carrera);
    }

    @Override
    public List<Carrera> listAll() {
        return carreraRepository.findAll();
    }

    @Override
    public Carrera search(Long id) {
        Optional<Carrera> search = carreraRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(Carrera carrera) {
        try {
            carreraRepository.save(carrera);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            carreraRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Carrera carrera) {
        boolean result = false;
        for (Carrera a : listAll()) {
            if (a.getNombre_carrera().equals(carrera.getNombre_carrera())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
