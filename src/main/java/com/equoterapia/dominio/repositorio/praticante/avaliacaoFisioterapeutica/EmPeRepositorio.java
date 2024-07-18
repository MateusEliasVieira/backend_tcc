package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EmPe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmPeRepositorio extends JpaRepository<EmPe, Long> {
    @Query("select emPe from EmPe emPe where emPe.praticante.idPraticante = :idPraticante")
    public Optional<EmPe> buscarEmPePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
