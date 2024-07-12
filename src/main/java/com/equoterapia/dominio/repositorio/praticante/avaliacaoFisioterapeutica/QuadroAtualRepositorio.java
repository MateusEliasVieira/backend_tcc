package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.QuadroAtual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuadroAtualRepositorio extends JpaRepository<QuadroAtual, Long> {
    @Query("select qa from QuadroAtual qa where qa.praticante.idPraticante = :idPraticante")
    public Optional<QuadroAtual> buscarQuadroAtualPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
