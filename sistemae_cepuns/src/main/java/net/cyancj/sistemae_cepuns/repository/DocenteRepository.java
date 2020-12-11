package net.cyancj.sistemae_cepuns.repository;

import net.cyancj.sistemae_cepuns.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, String> {
}
