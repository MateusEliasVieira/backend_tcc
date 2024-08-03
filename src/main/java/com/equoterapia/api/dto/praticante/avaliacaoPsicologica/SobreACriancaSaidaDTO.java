package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SobreACriancaSaidaDTO {

    // Perguntas iniciais sobre a criança

    private Long idSobreACrianca;
    private SImOuNaoEnum fezTerapiaEquina;
    private SImOuNaoEnum criancaPlanejada;
    private SImOuNaoEnum cuidadosPreNatais;
    private SImOuNaoEnum chorouNoNascimento;
    private String alimentacao;
    private String observacao;

}

