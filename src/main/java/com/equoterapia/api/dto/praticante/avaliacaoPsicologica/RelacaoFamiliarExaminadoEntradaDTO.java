package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelacaoFamiliarExaminadoEntradaDTO {

    // Relação da família com o examinado (percepção do entrevistador)

    private Long idRelacaoFamiliarExaminado;
    @Enumerated @NotNull
    private PreencherLegendaEnum adequado;
    @Enumerated @NotNull
    private PreencherLegendaEnum superprotecao;
    @Enumerated @NotNull
    private PreencherLegendaEnum dificuldadePerceberDeficiencias;
    @Enumerated @NotNull
    private PreencherLegendaEnum rejeicao;
    @Enumerated @NotNull
    private PreencherLegendaEnum indiferenca;
    @Enumerated @NotNull
    private PreencherLegendaEnum ansiedadePercebidaEntrevistador;


    private PraticanteIdDTO praticante;

}

