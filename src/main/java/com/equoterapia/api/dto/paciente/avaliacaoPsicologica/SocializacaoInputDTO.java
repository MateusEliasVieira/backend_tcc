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
public class SocializacaoInputDTO {

    // Socialização

    private Long idSocializacao;
    @Enumerated @NotBlank
    private PreencherLegenda interageBemComOutrasCriancas;
    @Enumerated @NotBlank
    private PreencherLegenda interageBemComAdultos;
    @Enumerated @NotBlank
    private PreencherLegenda buscaContatoSocial;
    @Enumerated @NotBlank
    private PreencherLegenda temOportunidadeContato;
    @Enumerated @NotBlank
    private PreencherLegenda fazContatoVisual;

    private PacienteIdDTO paciente;

}

