package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvaliacaoPsicologicaEntradaDTO {

    // Avaliação dos aspectos psicológicos

    private Long idAvaliacaoPsicologica;
    private String expectativasFamiliaresTerapiaEquina;
    private String resumoCasoObservacoesComplementares;
    private String imagemAssinaturaOuCRPECarimbo;

    @NotNull
    private PraticanteIdDTO praticante;

}

