package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.Paciente;
import com.equoterapia.domain.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComportamentoOutputDTO {

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


    private Paciente paciente;

}
