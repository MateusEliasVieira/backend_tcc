package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
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

    private PacienteIdDTO paciente;

}
