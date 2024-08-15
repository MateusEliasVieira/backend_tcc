package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeSaidaDTO {

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

    private PraticanteIdDTO praticante;

}

