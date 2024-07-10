package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvaliacaoFisioterapeuticaRepositorio extends JpaRepository<AvaliacaoFisioterapeutica, Long> {
    @Query("select af from AvaliacaoFisioterapeutica af where af.praticante.idPraticante = :idPraticante")
    public Optional<AvaliacaoFisioterapeutica> buscarAvaliacaoFisioterapeuticaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
