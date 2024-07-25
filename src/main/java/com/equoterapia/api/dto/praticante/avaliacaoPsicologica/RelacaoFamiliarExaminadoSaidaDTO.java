package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelacaoFamiliarExaminadoSaidaDTO {

    // Relação da família com o examinado (percepção do entrevistador)

    private Long idRelacaoFamiliarExaminado;
    private PreencherLegendaEnum adequado;
    private PreencherLegendaEnum superprotecao;
    private PreencherLegendaEnum dificuldadePerceberDeficiencias;
    private PreencherLegendaEnum rejeicao;
    private PreencherLegendaEnum indiferenca;
    private PreencherLegendaEnum ansiedadePercebidaEntrevistador;

}

