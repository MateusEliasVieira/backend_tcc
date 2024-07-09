package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Comportamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComportamentoRepositorio extends JpaRepository<Comportamento, Long> {
    @Query("select c from Comportamento c where c.praticante.idPraticante = :idPraticante")
    public Optional<Comportamento> buscarComportamentoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
