package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SaudeMental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaudeMentalRepositorio extends JpaRepository<SaudeMental, Long> {
    @Query("select sm from SaudeMental sm where sm.praticante.idPraticante = :idPraticante")
    public Optional<SaudeMental> buscarSaudeMentalPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
