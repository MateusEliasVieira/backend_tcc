package com.equoterapia.dominio.repositorio.praticante.evolucao;

import com.equoterapia.dominio.modelo.praticante.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvolucaoRepositorio extends JpaRepository<Evolucao, Long> {

    @Query("select e from Evolucao e where e.praticante.idPraticante = :idPraticante")
    public Optional<List<Evolucao>> buscarEvolucoesPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);




}
