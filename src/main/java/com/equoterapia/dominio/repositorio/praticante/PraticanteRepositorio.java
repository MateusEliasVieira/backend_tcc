package com.equoterapia.dominio.repositorio.praticante;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraticanteRepositorio extends JpaRepository<Praticante,Long> {
}
