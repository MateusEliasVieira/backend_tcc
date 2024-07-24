package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeEntradaDTO {

    // Saúde

    private Long idSaude;
    private String alergias;
    private String convulsoes;
    private String doencas;
    private String digestao;
    private String transtornoAlimentar;
    private String respiracao;
    private String sono;
    private String deficitCognitivo;

    @NotNull
    private PraticanteIdDTO praticante;

}

