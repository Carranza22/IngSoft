package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Ciclo;
import net.cyancj.sistemae_cepuns.repository.CicloRepository;
import net.cyancj.sistemae_cepuns.service.ICicloService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CicloServiceImpl implements ICicloService {

    private final CicloRepository cicloRepository;

    public CicloServiceImpl(CicloRepository cicloRepository) {
        this.cicloRepository = cicloRepository;
    }


    @Override
    public Ciclo add(Ciclo ciclo) {
        return cicloRepository.saveAndFlush(ciclo);
    }

    @Override
    public List<Ciclo> listAll() {
        return cicloRepository.findAll();
    }

    @Override
    public Ciclo search(Long id) {
        Optional<Ciclo> search = cicloRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(Ciclo ciclo) {
        try {
            cicloRepository.save(ciclo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            cicloRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Ciclo ciclo) {
        boolean result = false;
        for (Ciclo a : listAll()) {
            if (a.getAnio().equals(ciclo.getAnio()) && a.getN_ciclo() == ciclo.getN_ciclo()) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean inscripcionesHabilitadas() {
        boolean result = false;
        for (Ciclo a : listAll()) {
            if (a.getEstado_matricula() == 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Ciclo inscripcionHabilitada() {
        for (Ciclo a : listAll()) {
            if (a.getEstado_matricula() == 1) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Long idUltimaInscripcion() {
        List<Ciclo> listCiclos = listAll();
        return (listCiclos.size() > 0) ? listCiclos.get(listCiclos.size() - 1).getId() : null;
    }

}
