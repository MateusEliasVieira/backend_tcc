package com.equoterapia.dominio.repositorio.praticante.planoTerapeuticoSingular;

import com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanoTerapeuticoSingularRepositorio extends JpaRepository<PlanoTerapeuticoSingular, Long> {
    @Query("select pts from PlanoTerapeuticoSingular pts where pts.praticante.idPraticante = :idPraticante")
    public Optional<PlanoTerapeuticoSingular> buscarPlanoTerapeuticoSingularPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
