package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.SImOuNaoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SobreACriancaEntradaDTO {

    // Perguntas iniciais sobre a criança

    private Long idSobreACrianca;
    private SImOuNaoEnum fezTerapiaEquina;
    private SImOuNaoEnum criancaPlanejada;
    private SImOuNaoEnum cuidadosPreNatais;
    private SImOuNaoEnum chorouNoNascimento;
    private String alimentacao;
    private String observacao;

    @NotNull
    private PraticanteIdDTO praticante;

}

