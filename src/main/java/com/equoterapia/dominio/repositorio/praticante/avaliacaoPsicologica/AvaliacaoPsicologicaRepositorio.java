package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.AvaliacaoPsicologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvaliacaoPsicologicaRepositorio extends JpaRepository<AvaliacaoPsicologica, Long> {
    @Query("select ap from AvaliacaoPsicologica ap where ap.praticante.idPraticante = :idPraticante")
    public Optional<AvaliacaoPsicologica> buscarAvaliacaoPsicologicaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
