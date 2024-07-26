package com.equoterapia.dominio.repositorio.praticante.evolucao;

import com.equoterapia.dominio.modelo.praticante.Evolucao;
import com.equoterapia.dominio.servico.praticante.evolucao.impl.EvolucaoConsultaFaltas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EvolucaoGraficoRepositorio extends JpaRepository<Evolucao, Long> {

    @Query(value = "SELECT " +
            "    praticante_id_praticante AS praticanteIdPraticante, " +
            "    YEAR(data) AS ano, " +
            "    MONTH(data) AS mes, " +
            "    COUNT(*) AS frequencia " +
            "FROM " +
            "    evolucao " +
            "WHERE " +
            "    estava_presente = 1 " +
            "    AND praticante_id_praticante = :idPraticante " +
            "    AND data BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY " +
            "    praticante_id_praticante, " +
            "    YEAR(data), " +
            "    MONTH(data) " +
            "ORDER BY " +
            "    praticante_id_praticante, " +
            "    ano, " +
            "    mes",
            nativeQuery = true)
    List<EvolucaoConsultaFrequenciaProjection> buscarQuantidadeDeFrequenciaDoPraticanteParaCadaMesEmUmIntervaloDeTempo(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal,
            @Param("idPraticante") Long idPraticante);


    @Query(value = "SELECT " +
            "    praticante_id_praticante AS praticanteIdPraticante, " +
            "    YEAR(data) AS ano, " +
            "    MONTH(data) AS mes, " +
            "    COUNT(*) AS faltas " +
            "FROM " +
            "    evolucao " +
            "WHERE " +
            "    estava_presente = 0 " +
            "    AND praticante_id_praticante = :idPraticante " +
            "    AND data BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY " +
            "    praticante_id_praticante, " +
            "    YEAR(data), " +
            "    MONTH(data) " +
            "ORDER BY " +
            "    praticante_id_praticante, " +
            "    ano, " +
            "    mes",
            nativeQuery = true)
    List<EvolucaoConsultaFaltasProjection> buscarQuantidadeDeFaltasDoPraticanteParaCadaMesEmUmIntervaloDeTempo(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal,
            @Param("idPraticante") Long idPraticante);

}
