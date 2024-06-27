package com.equoterapia.dominio.modelo.patient.physicalTherapyAssessment;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GruposMusculares {

    // Grupos Musculares e Escala de Ashworth Modificada

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

