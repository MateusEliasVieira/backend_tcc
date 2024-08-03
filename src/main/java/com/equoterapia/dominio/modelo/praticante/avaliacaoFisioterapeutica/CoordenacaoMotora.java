package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
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
public class CoordenacaoMotora {

    // Coordenação Motora

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordenacaoMotora;
    private SImOuNaoEnum testeMaoObjeto;
    private String consideracoesTesteMaoObjeto;
    private SImOuNaoEnum indiceNarizUnilateral;
    private String consideracoesIndiceNarizUnilateral;
    private SImOuNaoEnum testeIndiceIndice;
    private String consideracoesTesteIndiceIndice;
    private SImOuNaoEnum movimentosAlternados;
    private String consideracoesMovimentosAlternados;
    private SImOuNaoEnum testeAlcancePegar;
    private String consideracoesTesteAlcancePegar;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

