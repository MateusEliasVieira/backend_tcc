package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegenda;
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
    private PreencherLegenda adequado;
    @Enumerated @NotNull
    private PreencherLegenda superprotecao;
    @Enumerated @NotNull
    private PreencherLegenda dificuldadePerceberDeficiencias;
    @Enumerated @NotNull
    private PreencherLegenda rejeicao;
    @Enumerated @NotNull
    private PreencherLegenda indiferenca;
    @Enumerated @NotNull
    private PreencherLegenda ansiedadePercebidaEntrevistador;


    private PraticanteIdDTO paciente;

}

