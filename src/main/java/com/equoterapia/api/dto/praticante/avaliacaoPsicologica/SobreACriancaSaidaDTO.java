package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SobreACriancaSaidaDTO {

    // Perguntas iniciais sobre a criança

    private Long idSobreACrianca;
    private Boolean fezTerapiaEquina;
    private Boolean criancaPlanejada;
    private Boolean cuidadosPreNatais;
    private Boolean chorouNoNascimento;
    private String alimentacao;
    private String observacao;

}

