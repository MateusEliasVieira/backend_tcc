package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComportamentoSaidaDTO {

    // Comportamento

    private Long idComportamento;
    private PreencherLegendaEnum agitacao;
    private PreencherLegendaEnum toleranciaFrustracao;
    private PreencherLegendaEnum respeitaLimitesRegras;
    private PreencherLegendaEnum oposicao;
    private PreencherLegendaEnum atencaoConcentracao;

}
