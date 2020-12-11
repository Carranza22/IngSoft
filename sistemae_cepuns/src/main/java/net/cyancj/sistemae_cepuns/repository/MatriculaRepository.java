package net.cyancj.sistemae_cepuns.repository;

import net.cyancj.sistemae_cepuns.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
}
