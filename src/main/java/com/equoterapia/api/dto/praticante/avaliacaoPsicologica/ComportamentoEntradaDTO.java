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
public class ComportamentoEntradaDTO {

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


    private PraticanteIdDTO paciente;

}
