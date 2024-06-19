package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelacaoFamiliarExaminadoInputDTO {

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


    private PacienteIdDTO paciente;

}

