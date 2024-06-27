package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

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
    private Boolean testeMaoObjeto;
    private String consideracoesTesteMaoObjeto;
    private Boolean indiceNarizUnilateral;
    private String consideracoesIndiceNarizUnilateral;
    private Boolean testeIndiceIndice;
    private String consideracoesTesteIndiceIndice;
    private Boolean movimentosAlternados;
    private String consideracoesMovimentosAlternados;
    private Boolean testeAlcancePegar;
    private String consideracoesTesteAlcancePegar;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

