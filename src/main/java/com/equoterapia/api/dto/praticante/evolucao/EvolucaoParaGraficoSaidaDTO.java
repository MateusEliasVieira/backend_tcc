package com.equoterapia.api.dto.praticante.evolucao;

import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoConsultaFaltasProjection;
import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoConsultaFrequenciaProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvolucaoParaGraficoSaidaDTO {

    private List<EvolucaoConsultaFrequenciaProjection> frequencia;
    private List<EvolucaoConsultaFaltasProjection> faltas;
    private List<String> meses;

}
