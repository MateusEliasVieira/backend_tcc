package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeEntradaDTO {

    // Saúde

    private Long idSaude;
    @NotBlank
    private String alergias;
    @NotBlank
    private String convulsoes;
    @NotBlank
    private String doencas;
    @NotBlank
    private String digestao;
    @NotBlank
    private String transtornoAlimentar;
    @NotBlank
    private String respiracao;
    @NotBlank
    private String sono;
    @NotBlank
    private String deficitCognitivo;


    private PraticanteIdDTO paciente;

}

