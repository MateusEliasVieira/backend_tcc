package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
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
    @NotNull
    private Boolean fezTerapiaEquina;
    @NotNull
    private Boolean criancaPlanejada;
    @NotNull
    private Boolean cuidadosPreNatais;
    @NotNull
    private Boolean chorouNoNascimento;
    private String alimentacao;
    private String observacao;

    private PraticanteIdDTO praticante;

}

