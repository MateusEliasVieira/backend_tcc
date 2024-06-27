package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.Praticante;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AvaliacaoFisioterapeutica {

    // Avaliação Fisioterapêutica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacaoFisioterapeutica;
    private String diagnosticoFisioterapeutico;
    private String historicoGravidez;

    // Descrever Tonus Muscular
    private String tonusMuscular;

    // Conclusão/Indicação para Equoterapia
    private String conclusaoIndicacaoEquoterapia;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}


