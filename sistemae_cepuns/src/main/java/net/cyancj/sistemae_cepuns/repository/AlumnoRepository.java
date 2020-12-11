package net.cyancj.sistemae_cepuns.repository;

import net.cyancj.sistemae_cepuns.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,String> {
}
