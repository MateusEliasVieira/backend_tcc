package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SocializacaoSaidaDTO {

    // Socialização

    private Long idSocializacao;
    private PreencherLegendaEnum interageBemComOutrasCriancas;
    private PreencherLegendaEnum interageBemComAdultos;
    private PreencherLegendaEnum buscaContatoSocial;
    private PreencherLegendaEnum temOportunidadeContato;
    private PreencherLegendaEnum fazContatoVisual;

}

