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
public class TracosDePersonalidadeInputDTO {

    // Traços de personalidade

    private Long idTracosDePersonalidade;
    @Enumerated @NotNull
    private PreencherLegendaEnum extroversao;
    @Enumerated @NotNull
    private PreencherLegendaEnum fobia;
    @Enumerated @NotNull
    private PreencherLegendaEnum obsessao;
    @Enumerated @NotNull
    private PreencherLegendaEnum introversao;
    @Enumerated @NotNull
    private PreencherLegendaEnum ansiedade;
    @Enumerated @NotNull
    private PreencherLegendaEnum histeria;
    @Enumerated @NotNull
    private PreencherLegendaEnum dependenciaEmocional;
    @Enumerated @NotNull
    private PreencherLegendaEnum timidez;

    private PraticanteIdDTO praticante;

}
