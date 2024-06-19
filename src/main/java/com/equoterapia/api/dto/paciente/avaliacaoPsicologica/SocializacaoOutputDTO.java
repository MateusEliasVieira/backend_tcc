package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.Paciente;
import com.equoterapia.domain.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SocializacaoOutputDTO {

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

    private Paciente paciente;

}

