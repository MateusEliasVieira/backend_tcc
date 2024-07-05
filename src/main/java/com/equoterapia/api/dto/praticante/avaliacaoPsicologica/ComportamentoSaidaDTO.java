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
public class ComportamentoSaidaDTO {

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


    private Praticante praticante;

}
