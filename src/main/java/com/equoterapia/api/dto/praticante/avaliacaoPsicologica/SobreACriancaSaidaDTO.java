package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import jakarta.validation.constraints.NotNull;
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

