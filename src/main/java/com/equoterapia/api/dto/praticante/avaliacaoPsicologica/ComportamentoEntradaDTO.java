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
public class ComportamentoEntradaDTO {

    // Comportamento

    private Long idComportamento;
    @Enumerated @NotNull
    private PreencherLegendaEnum agitacao;
    @Enumerated @NotNull
    private PreencherLegendaEnum toleranciaFrustracao;
    @Enumerated @NotNull
    private PreencherLegendaEnum respeitaLimitesRegras;
    @Enumerated @NotNull
    private PreencherLegendaEnum oposicao;
    @Enumerated @NotNull
    private PreencherLegendaEnum atencaoConcentracao;


    private PraticanteIdDTO praticante;

}
