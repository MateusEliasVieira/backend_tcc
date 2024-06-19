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
public class ComportamentoInputDTO {

    // Comportamento

    private Long idComportamento;
    @Enumerated @NotNull
    private PreencherLegenda agitacao;
    @Enumerated @NotNull
    private PreencherLegenda toleranciaFrustracao;
    @Enumerated @NotNull
    private PreencherLegenda respeitaLimitesRegras;
    @Enumerated @NotNull
    private PreencherLegenda oposicao;
    @Enumerated @NotNull
    private PreencherLegenda atencaoConcentracao;


    private PacienteIdDTO paciente;

}
