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
public class HabilidadesMotorasAVD {

    // Habilidades Motoras/AVD's

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidadesMotorasAVD;
    private SImOuNaoEnum alcancarObjetos;
    private String consideracoesAlcancarObjetos;
    private SImOuNaoEnum usoBimanual;
    private String consideracoesUsoBimanual;
    private SImOuNaoEnum alimentacaoIndependente;
    private String consideracoesAlimentacaoIndependente;
    private SImOuNaoEnum vestirIndependente;
    private String consideracoesVestirIndependente;
    private SImOuNaoEnum pegarObjetos;
    private String consideracoesPegarObjetos;
    private SImOuNaoEnum negligenciaMembro;
    private String consideracoesNegligenciaMembro;
    private SImOuNaoEnum higienePessoal;
    private String consideracoesHigienePessoal;
    private SImOuNaoEnum andar;
    private String consideracoesAndar;
    private SImOuNaoEnum escritaManual;
    private String consideracoesEscritaManual;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

