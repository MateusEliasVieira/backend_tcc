package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegenda;
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

    private PraticanteIdDTO paciente;

}

