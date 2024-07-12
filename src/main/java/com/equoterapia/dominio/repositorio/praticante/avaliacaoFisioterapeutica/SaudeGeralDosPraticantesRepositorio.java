package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDoPraticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaudeGeralDosPraticantesRepositorio extends JpaRepository<SaudeGeralDoPraticante, Long> {
    @Query("select sgdp from SaudeGeralDoPraticante sgdp where sgdp.praticante.idPraticante = :idPraticante")
    public Optional<SaudeGeralDoPraticante> buscarSaudeGeralDosPraticantesPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
