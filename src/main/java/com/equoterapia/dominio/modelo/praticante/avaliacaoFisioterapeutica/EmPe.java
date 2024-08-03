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
public class EmPe {

    // Coordenação Motora

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmPe;
    private SImOuNaoEnum sequenciaDeMovimentos;
    private String consideracoesSequenciaDeMovimentos;
    private SImOuNaoEnum entrarSairPosicaoSentadoChao;
    private String consideracoesEntrarSairPosicaoSentadoChao;
    private SImOuNaoEnum sentadoCadeira;
    private String consideracoesSentadoCadeira;
    private SImOuNaoEnum posturaEquilibrio;
    private String consideracoesPosturaEquilibrio;
    private SImOuNaoEnum seqMovRolaSenta;
    private String consideracoesSeqMovRolaSenta;
    private SImOuNaoEnum passaParaSentado;
    private String consideracoesPassaParaSentado;
    private String observacoes;


    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

