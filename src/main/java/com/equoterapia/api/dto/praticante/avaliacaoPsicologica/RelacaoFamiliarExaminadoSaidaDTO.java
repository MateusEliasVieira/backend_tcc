package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelacaoFamiliarExaminadoSaidaDTO {

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

}

