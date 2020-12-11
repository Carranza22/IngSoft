package net.cyancj.sistemae_cepuns.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.cyancj.sistemae_cepuns.entity.Carrera;

@Repository
public interface CarreraRepository  extends JpaRepository<Carrera,Long> {
}
