package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RotinaRepositorio extends JpaRepository<Rotina, Long> {
    @Query("select r from Rotina r where r.praticante.idPraticante = :idPraticante")
    public Optional<Rotina> buscarRotinaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
