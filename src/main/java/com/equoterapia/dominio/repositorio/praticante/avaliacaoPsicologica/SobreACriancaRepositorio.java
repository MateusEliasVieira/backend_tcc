package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SobreACriancaRepositorio extends JpaRepository<SobreACrianca, Long> {
    @Query("select sac from SobreACrianca sac where sac.praticante.idPraticante = :idPraticante")
    public Optional<SobreACrianca> buscarSobreACriancaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
