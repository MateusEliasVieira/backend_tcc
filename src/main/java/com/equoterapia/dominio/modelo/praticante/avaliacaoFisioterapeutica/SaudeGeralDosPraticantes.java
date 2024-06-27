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
public class SaudeGeralDosPraticantes {

    // Saúde geral do paciente

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaudeGeralDosPacientes;
    private Boolean convulsoesAnteriores;
    private String consideracoesConvulsoesAnteriores;
    private Boolean convulsoesAtuais;
    private String consideracoesConvulsoesAtuais;
    private String frequenciaConvulsoesAtuais;
    private Boolean medicamentos;
    private String consideracoesMedicamentos;
    private Boolean constipacao;
    private String consideracoesConstipacao;
    private Boolean sono;
    private String consideracoesSono;
    private Boolean audicao;
    private String consideracoesAudicao;
    private Boolean visao;
    private String consideracoesVisao;
    private Boolean refluxoGastroesofagico;
    private String consideracoesRefluxoGastroesofagico;
    private Boolean intervencoesCirurgicas;
    private String consideracoesIntervencoesCirurgicas;
    private Boolean alergias;
    private String consideracoesAlergias;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

