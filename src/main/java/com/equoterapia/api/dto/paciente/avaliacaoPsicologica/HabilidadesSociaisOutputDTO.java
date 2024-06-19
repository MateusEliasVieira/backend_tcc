package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.Paciente;
import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabilidadesSociaisOutputDTO {

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


    private Paciente paciente;

}

