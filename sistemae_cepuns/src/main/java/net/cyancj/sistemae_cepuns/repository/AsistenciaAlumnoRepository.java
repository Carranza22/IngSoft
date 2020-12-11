package net.cyancj.sistemae_cepuns.repository;

import net.cyancj.sistemae_cepuns.entity.AsistenciaAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaAlumnoRepository extends JpaRepository<AsistenciaAlumno, Long> {
}
