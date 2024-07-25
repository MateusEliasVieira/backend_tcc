package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoPsicologicaSaidaDTO {

    // Avaliação dos aspectos psicológicos

    private Long idAvaliacaoPsicologica;
    private String expectativasFamiliaresTerapiaEquina;
    private String resumoCasoObservacoesComplementares;
    private String imagemAssinaturaOuCRPECarimbo;

}

