package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.AsistenciaDocente;
import net.cyancj.sistemae_cepuns.repository.AsistenciaDocenteRepository;
import net.cyancj.sistemae_cepuns.service.IAsistenciaDocenteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaDocenteServiceImpl implements IAsistenciaDocenteService {
    private final AsistenciaDocenteRepository asistenciaDocenteRepository;

    public AsistenciaDocenteServiceImpl(AsistenciaDocenteRepository asistenciaDocenteRepository) {
        this.asistenciaDocenteRepository = asistenciaDocenteRepository;
    }

    @Override
    public AsistenciaDocente add(AsistenciaDocente asistenciaDocente) {
        return asistenciaDocenteRepository.saveAndFlush(asistenciaDocente);
    }

    @Override
    public List<AsistenciaDocente> listAll() {
        return asistenciaDocenteRepository.findAll();
    }

    @Override
    public AsistenciaDocente search(Long id) {
        Optional<AsistenciaDocente> search = asistenciaDocenteRepository.findById(id);
        return search.orElse(null);
    }

    @Override
    public boolean update(AsistenciaDocente asistenciaDocente) {
        try {
            asistenciaDocenteRepository.save(asistenciaDocente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            asistenciaDocenteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean searchByName(AsistenciaDocente asistenciaDocente) {
        for (AsistenciaDocente a : listAll()) {
            if (a.getAsistencia().getFecha().getTime() == asistenciaDocente.getAsistencia().getFecha().getTime() && a.getDocente().getDni().equals(asistenciaDocente.getDocente().getDni())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean searchForDniIdAsistencia(String dni, Long idAsistencia) {
        for (AsistenciaDocente a : listAll()) {
            if (a.getDocente().getDni().equals(dni) && a.getAsistencia().getId().equals(idAsistencia)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<AsistenciaDocente> listAsistenciaForCicloDnI(Long id_ciclo, String dni) {
        List<AsistenciaDocente> listAsistencia = new ArrayList<>();
        for (AsistenciaDocente a : listAll()) {
            if (a.getAsistencia().getCiclo().getId().equals(id_ciclo) && a.getDocente().getDni().equals(dni)) {
                listAsistencia.add(a);
            }
        }
        return listAsistencia;
    }
}
