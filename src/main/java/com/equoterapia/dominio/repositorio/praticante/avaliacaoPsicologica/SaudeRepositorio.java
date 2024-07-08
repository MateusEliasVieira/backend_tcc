package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Saude;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaudeRepositorio extends JpaRepository<Saude, Long> {
    @Query("select s from Saude s where s.praticante.idPraticante = :idPraticante")
    public Optional<Saude> buscarSaudePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
