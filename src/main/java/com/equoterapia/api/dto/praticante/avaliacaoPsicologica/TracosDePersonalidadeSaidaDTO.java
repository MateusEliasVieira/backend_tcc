package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TracosDePersonalidadeSaidaDTO {

    // Traços de personalidade

    private Long idTracosDePersonalidade;
    private PreencherLegendaEnum extroversao;
    private PreencherLegendaEnum fobia;
    private PreencherLegendaEnum obsessao;
    private PreencherLegendaEnum introversao;
    private PreencherLegendaEnum ansiedade;
    private PreencherLegendaEnum histeria;
    private PreencherLegendaEnum dependenciaEmocional;
    private PreencherLegendaEnum timidez;

    private Boolean finalizado;

    private PraticanteIdDTO praticante;

}
