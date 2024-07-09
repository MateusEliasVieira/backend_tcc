package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Socializacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocializacaoRepositorio extends JpaRepository<Socializacao, Long> {
    @Query("select s from Socializacao s where s.praticante.idPraticante = :idPraticante")
    public Optional<Socializacao> buscarSocializacaoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
