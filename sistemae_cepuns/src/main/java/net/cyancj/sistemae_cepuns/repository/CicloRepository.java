package net.cyancj.sistemae_cepuns.repository;

import net.cyancj.sistemae_cepuns.entity.Ciclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, Long> {
}
