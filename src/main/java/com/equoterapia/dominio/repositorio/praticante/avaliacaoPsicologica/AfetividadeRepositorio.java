package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Afetividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfetividadeRepositorio extends JpaRepository<Afetividade, Long> {
    @Query("select a from Afetividade a where a.praticante.idPraticante = :idPraticante")
    public Optional<Afetividade> buscarAfetividadePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
