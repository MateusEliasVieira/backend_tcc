package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioDinamico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquilibrioDinamicoRepositorio extends JpaRepository<EquilibrioDinamico, Long> {
    @Query("select ed from EquilibrioDinamico ed where ed.praticante.idPraticante = :idPraticante")
    public Optional<EquilibrioDinamico> buscarEquilibrioDinamicoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
