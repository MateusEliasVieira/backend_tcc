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
    private PreencherLegendaEnum agitacao;
    private PreencherLegendaEnum toleranciaFrustracao;
    private PreencherLegendaEnum respeitaLimitesRegras;
    private PreencherLegendaEnum oposicao;
    private PreencherLegendaEnum atencaoConcentracao;

}
