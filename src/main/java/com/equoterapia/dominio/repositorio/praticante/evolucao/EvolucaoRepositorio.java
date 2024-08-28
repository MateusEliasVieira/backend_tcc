package com.equoterapia.dominio.repositorio.praticante.evolucao;

import com.equoterapia.dominio.modelo.praticante.evolucao.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EvolucaoRepositorio extends JpaRepository<Evolucao, Long> {

    @Query("select e from Evolucao e where e.praticante.idPraticante = :idPraticante order by e.data desc")
    public Optional<List<Evolucao>> buscarEvolucoesPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);

    //@Query("SELECT e FROM Evolucao e WHERE e.praticante.idPraticante = :idPraticante and e.data = :data") // se você está comparando datas com precisão até o nível de segundos.
    @Query("SELECT e FROM Evolucao e WHERE e.praticante.idPraticante = :idPraticante AND FUNCTION('DATE', e.data) = :data") // se você está comparando apenas as partes de data, ignorando horas, minutos e segundos.
    public Optional<Evolucao> buscarEvolucaoDoPraticantePorData(@Param("idPraticante") Long idPraticante, @Param("data") Date data);

    @Query("SELECT e FROM Evolucao e WHERE e.data BETWEEN :dataInicial AND :dataFinal AND e.praticante.idPraticante = :idPraticante")
    public Optional<List<Evolucao>> buscarEvolucoesDoPraticanteEmIntervaloDeData(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal, @Param("idPraticante") Long idPraticante);

}
