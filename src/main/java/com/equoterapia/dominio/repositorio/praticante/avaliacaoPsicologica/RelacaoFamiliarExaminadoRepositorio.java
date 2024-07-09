package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelacaoFamiliarExaminadoRepositorio extends JpaRepository<RelacaoFamiliarExaminado, Long> {
    @Query("select rfe from RelacaoFamiliarExaminado rfe where rfe.praticante.idPraticante = :idPraticante")
    public Optional<RelacaoFamiliarExaminado> buscarRelacaoFamiliarExaminadoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
