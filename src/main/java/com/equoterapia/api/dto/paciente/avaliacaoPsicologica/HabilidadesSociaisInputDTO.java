package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabilidadesSociaisInputDTO {

    // Habilidades sociais

    private Long idHabilidadesSociais;
    @Enumerated @NotBlank
    private PreencherLegenda passividade;
    @Enumerated @NotBlank
    private PreencherLegenda autoagressao;
    @Enumerated @NotBlank
    private PreencherLegenda heteroagressividade;
    @Enumerated @NotBlank
    private PreencherLegenda assertividade;


    private PacienteIdDTO paciente;

}

