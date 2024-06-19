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
public class TracosDePersonalidadeInputDTO {

    // Traços de personalidade

    private Long idTracosDePersonalidade;
    @Enumerated @NotNull
    private PreencherLegenda extroversao;
    @Enumerated @NotNull
    private PreencherLegenda fobia;
    @Enumerated @NotNull
    private PreencherLegenda obsessao;
    @Enumerated @NotNull
    private PreencherLegenda introversao;
    @Enumerated @NotNull
    private PreencherLegenda ansiedade;
    @Enumerated @NotNull
    private PreencherLegenda histeria;
    @Enumerated @NotNull
    private PreencherLegenda dependenciaEmocional;
    @Enumerated @NotNull
    private PreencherLegenda timidez;

    private PraticanteIdDTO paciente;

}
