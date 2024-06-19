package com.equoterapia.api.dto.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GruposMusculares {

    // Grupos Musculares e Escala de Ashworth Modificada

    private Long idGruposMusculares;
    private String flexoresOmbroDireito;
    private String flexoresOmbroEsquerdo;
    private String extensoresOmbroDireito;
    private String extensoresOmbroEsquerdo;
    private String flexoresCotoveloDireito;
    private String flexoresCotoveloEsquerdo;
    private String extensoresCotoveloDireito;
    private String extensoresCotoveloEsquerdo;
    private String flexoresPulsoDireito;
    private String flexoresPulsoEsquerdo;
    private String extensoresPulsoDireito;
    private String extensoresPulsoEsquerdo;
    private String flexoresQuadrilDireito;
    private String flexoresQuadrilEsquerdo;
    private String extensoresQuadrilDireito;
    private String extensoresQuadrilEsquerdo;
    private String flexoresJoelhoDireito;
    private String flexoresJoelhoEsquerdo;
    private String dorsiflexoresTornozeloDireito;
    private String dorsiflexoresTornozeloEsquerdo;
    private String plantiflexoresTornozeloDireito;
    private String plantiflexoresTornozeloEsquerdo;

    private Paciente paciente;

}

