package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Asistencia;
import net.cyancj.sistemae_cepuns.repository.AsistenciaRepository;
import net.cyancj.sistemae_cepuns.service.IAsistenciaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    @Override
    public Asistencia add(Asistencia asistencia) {
        return asistenciaRepository.saveAndFlush(asistencia);
    }

    @Override
    public List<Asistencia> listAll() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Asistencia search(Long id) {
        Optional<Asistencia> search = asistenciaRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(Asistencia asistencia) {
        try {
            asistenciaRepository.save(asistencia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            asistenciaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(Asistencia asistencia) {
        return false;
    }

    @Override
    public boolean searchByDate(Date date, Long idCiclo) {
        for (Asistencia a : listAll()) {
            if (a.getFecha().getTime() == date.getTime() && a.getCiclo().getId().equals(idCiclo)) {
                return true;
            }
        }
        return false;
    }

    public Asistencia getForFechaCiclo(Date date, Long ciclo) {
        for (Asistencia a : listAll()) {
            if (a.getFecha().getTime() == date.getTime() && a.getCiclo().getId().equals(ciclo)) {
                return a;
            }
        }
        return null;
    }

}
