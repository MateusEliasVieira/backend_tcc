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
public class TracosDePersonalidadeEntradaDTO {

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

    @NotNull(message = "É preciso informar o praticante a ser atualizado!")
    private PraticanteIdDTO praticante;

}
