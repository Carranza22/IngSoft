package net.cyancj.sistemae_cepuns.service.serviceImpl;

import net.cyancj.sistemae_cepuns.entity.Nota;
import net.cyancj.sistemae_cepuns.repository.NotaRepository;
import net.cyancj.sistemae_cepuns.service.INotaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements INotaService {

    private final NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Override
    public Nota add(Nota nota) {
        return notaRepository.saveAndFlush(nota);
    }

    @Override
    public List<Nota> listAll() {
        return notaRepository.findAll();
    }

    @Override
    public Nota search(Long id) {
        return null;
    }

    @Override
    public boolean update(Nota nota) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean searchByName(Nota nota) {
        return false;
    }

    @Override
    public boolean searchForTipoCicloFacultad(String tipo, Long id_ciclo, Long id_facultad) {
        for (Nota n : listAll()) {
            if (n.getTipo().equals(tipo) && n.getMatricula().getCiclo().getId().equals(id_ciclo) &&
                    n.getMatricula().getCarrera().getFacultad().getId().equals(id_facultad)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Double getNotaForMatriculaTipoNota(Long id_matricula, String tipo_nota) {
        Double nota = null;
        for (Nota n : listAll()) {
            if (n.getMatricula().getId().equals(id_matricula) &&
                    n.getTipo().equals(tipo_nota)) {
                nota = n.getNota();
                break;
            }
        }
        return nota;
    }
}
