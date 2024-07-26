package com.equoterapia.dominio.repositorio.praticante.evolucao;

public interface EvolucaoConsultaFaltasProjection {
    Long getPraticanteIdPraticante();
    Integer getAno();
    Integer getMes();
    Integer getFaltas();
}
