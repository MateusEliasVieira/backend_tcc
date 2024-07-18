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
public class EmPe {

    // Coordenação Motora

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmPe;
    private Boolean sequenciaDeMovimentos;
    private String consideracoesSequenciaDeMovimentos;
    private Boolean entrarSairPosicaoSentadoChao;
    private String consideracoesEntrarSairPosicaoSentadoChao;
    private Boolean sentadoCadeira;
    private String consideracoesSentadoCadeira;
    private Boolean posturaEquilibrio;
    private String consideracoesPosturaEquilibrio;
    private Boolean seqMovRolaSenta;
    private String consideracoesSeqMovRolaSenta;
    private Boolean passaParaSentado;
    private String consideracoesPassaParaSentado;


    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

