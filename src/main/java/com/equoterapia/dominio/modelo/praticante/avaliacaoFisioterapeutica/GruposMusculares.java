package com.equoterapia.dominio.modelo.patient.physicalTherapyAssessment;

import com.equoterapia.dominio.enums.GruposMuscularesEnum;
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
    private GruposMuscularesEnum flexoresOmbroDireito;
    private GruposMuscularesEnum flexoresOmbroEsquerdo;
    private GruposMuscularesEnum extensoresOmbroDireito;
    private GruposMuscularesEnum extensoresOmbroEsquerdo;
    private GruposMuscularesEnum flexoresCotoveloDireito;
    private GruposMuscularesEnum flexoresCotoveloEsquerdo;
    private GruposMuscularesEnum extensoresCotoveloDireito;
    private GruposMuscularesEnum extensoresCotoveloEsquerdo;
    private GruposMuscularesEnum flexoresPulsoDireito;
    private GruposMuscularesEnum flexoresPulsoEsquerdo;
    private GruposMuscularesEnum extensoresPulsoDireito;
    private GruposMuscularesEnum extensoresPulsoEsquerdo;
    private GruposMuscularesEnum flexoresQuadrilDireito;
    private GruposMuscularesEnum flexoresQuadrilEsquerdo;
    private GruposMuscularesEnum extensoresQuadrilDireito;
    private GruposMuscularesEnum extensoresQuadrilEsquerdo;
    private GruposMuscularesEnum flexoresJoelhoDireito;
    private GruposMuscularesEnum flexoresJoelhoEsquerdo;
    private GruposMuscularesEnum dorsiflexoresTornozeloDireito;
    private GruposMuscularesEnum dorsiflexoresTornozeloEsquerdo;
    private GruposMuscularesEnum plantiflexoresTornozeloDireito;
    private GruposMuscularesEnum plantiflexoresTornozeloEsquerdo;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

