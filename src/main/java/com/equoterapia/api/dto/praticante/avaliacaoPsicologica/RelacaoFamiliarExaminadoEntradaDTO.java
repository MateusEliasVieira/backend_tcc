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
    private PreencherLegendaEnum adequado;
    private PreencherLegendaEnum superprotecao;
    private PreencherLegendaEnum dificuldadePerceberDeficiencias;
    private PreencherLegendaEnum rejeicao;
    private PreencherLegendaEnum indiferenca;
    private PreencherLegendaEnum ansiedadePercebidaEntrevistador;

    @NotNull
    private PraticanteIdDTO praticante;

}

