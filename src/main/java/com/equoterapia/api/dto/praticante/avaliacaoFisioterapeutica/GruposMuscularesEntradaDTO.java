package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GruposMuscularesEntradaDTO {

    // Grupos Musculares e Escala de Ashworth Modificada

    private Long idGruposMusculares;
    @NotBlank
    private String flexoresOmbroDireito;
    @NotBlank
    private String flexoresOmbroEsquerdo;
    @NotBlank
    private String extensoresOmbroDireito;
    @NotBlank
    private String extensoresOmbroEsquerdo;
    @NotBlank
    private String flexoresCotoveloDireito;
    @NotBlank
    private String flexoresCotoveloEsquerdo;
    @NotBlank
    private String extensoresCotoveloDireito;
    @NotBlank
    private String extensoresCotoveloEsquerdo;
    @NotBlank
    private String flexoresPulsoDireito;
    @NotBlank
    private String flexoresPulsoEsquerdo;
    @NotBlank
    private String extensoresPulsoDireito;
    @NotBlank
    private String extensoresPulsoEsquerdo;
    @NotBlank
    private String flexoresQuadrilDireito;
    @NotBlank
    private String flexoresQuadrilEsquerdo;
    @NotBlank
    private String extensoresQuadrilDireito;
    @NotBlank
    private String extensoresQuadrilEsquerdo;
    @NotBlank
    private String flexoresJoelhoDireito;
    @NotBlank
    private String flexoresJoelhoEsquerdo;
    @NotBlank
    private String dorsiflexoresTornozeloDireito;
    @NotBlank
    private String dorsiflexoresTornozeloEsquerdo;
    @NotBlank
    private String plantiflexoresTornozeloDireito;
    @NotBlank
    private String plantiflexoresTornozeloEsquerdo;

    @NotNull
    private PraticanteIdDTO praticante;

}

