package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinguagemRepositorio extends JpaRepository<Linguagem, Long> {
    @Query("select l from Linguagem l where l.praticante.idPraticante = :idPraticante")
    public Optional<Linguagem> buscarLinguagemPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
