package net.cyancj.sistemae_cepuns.repository;

import net.cyancj.sistemae_cepuns.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
}
