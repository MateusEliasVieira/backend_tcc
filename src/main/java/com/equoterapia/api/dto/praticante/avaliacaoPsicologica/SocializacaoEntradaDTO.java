package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SocializacaoEntradaDTO {

    // Socialização

    private Long idSocializacao;
    @Enumerated @NotBlank
    private PreencherLegendaEnum interageBemComOutrasCriancas;
    @Enumerated @NotBlank
    private PreencherLegendaEnum interageBemComAdultos;
    @Enumerated @NotBlank
    private PreencherLegendaEnum buscaContatoSocial;
    @Enumerated @NotBlank
    private PreencherLegendaEnum temOportunidadeContato;
    @Enumerated @NotBlank
    private PreencherLegendaEnum fazContatoVisual;

    private PraticanteIdDTO praticante;

}

