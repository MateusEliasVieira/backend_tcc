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
public class SaudeGeralDoPraticante {

    // Saúde geral do paciente

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaudeGeralDoPraticante;
    private SImOuNaoEnum convulsoesAnteriores;
    private String consideracoesConvulsoesAnteriores;
    private SImOuNaoEnum convulsoesAtuais;
    private String consideracoesConvulsoesAtuais;
    private String frequenciaConvulsoesAtuais;
    private SImOuNaoEnum medicamentos;
    private String consideracoesMedicamentos;
    private SImOuNaoEnum constipacao;
    private String consideracoesConstipacao;
    private SImOuNaoEnum sono;
    private String consideracoesSono;
    private SImOuNaoEnum audicao;
    private String consideracoesAudicao;
    private SImOuNaoEnum visao;
    private String consideracoesVisao;
    private SImOuNaoEnum refluxoGastroesofagico;
    private String consideracoesRefluxoGastroesofagico;
    private SImOuNaoEnum intervencoesCirurgicas;
    private String consideracoesIntervencoesCirurgicas;
    private SImOuNaoEnum alergias;
    private String consideracoesAlergias;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

