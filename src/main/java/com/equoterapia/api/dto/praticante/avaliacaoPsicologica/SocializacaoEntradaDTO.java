package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SocializacaoEntradaDTO {

    // Socialização

    private Long idSocializacao;
    
    private PreencherLegendaEnum interageBemComOutrasCriancas;
    private PreencherLegendaEnum interageBemComAdultos;
    private PreencherLegendaEnum buscaContatoSocial;
    private PreencherLegendaEnum temOportunidadeContato;
    private PreencherLegendaEnum fazContatoVisual;

    @NotNull
    private PraticanteIdDTO praticante;

}

