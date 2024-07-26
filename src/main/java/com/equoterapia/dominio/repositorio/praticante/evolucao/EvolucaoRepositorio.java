package com.equoterapia.dominio.repositorio.praticante.evolucao;

import com.equoterapia.dominio.modelo.praticante.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EvolucaoRepositorio extends JpaRepository<Evolucao, Long> {

    @Query("select e from Evolucao e where e.praticante.idPraticante = :idPraticante")
    public Optional<List<Evolucao>> buscarEvolucoesPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);

    @Query("SELECT e FROM Evolucao e WHERE e.praticante.idPraticante = :idPraticante AND FUNCTION('DATE', e.data) = :data")
    public Optional<Evolucao> buscarEvolucaoDoPraticantePorData(@Param("idPraticante") Long idPraticante, @Param("data") Date data);

    @Query("SELECT e FROM Evolucao e WHERE e.data BETWEEN :dataInicial AND :dataFinal AND e.praticante.idPraticante = :idPraticante")
    public Optional<List<Evolucao>> buscarEvolucoesDoPraticanteEmIntervaloDeData(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal, @Param("idPraticante") Long idPraticante);

}
