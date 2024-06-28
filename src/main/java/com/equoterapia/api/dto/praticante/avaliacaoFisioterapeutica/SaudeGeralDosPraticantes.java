package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeGeralDosPraticantes {

    // Saúde geral do paciente

    private Long idSaudeGeralDosPacientes;
    @NotNull
    private Boolean convulsoesAnteriores;
    @NotBlank
    private String consideracoesConvulsoesAnteriores;
    @NotNull
    private Boolean convulsoesAtuais;
    @NotBlank
    private String consideracoesConvulsoesAtuais;
    @NotBlank
    private String frequenciaConvulsoesAtuais;
    @NotNull
    private Boolean medicamentos;
    @NotBlank
    private String consideracoesMedicamentos;
    @NotNull
    private Boolean constipacao;
    @NotBlank
    private String consideracoesConstipacao;
    @NotNull
    private Boolean sono;
    @NotBlank
    private String consideracoesSono;
    @NotNull
    private Boolean audicao;
    @NotBlank
    private String consideracoesAudicao;
    @NotNull
    private Boolean visao;
    @NotBlank
    private String consideracoesVisao;
    @NotNull
    private Boolean refluxoGastroesofagico;
    @NotBlank
    private String consideracoesRefluxoGastroesofagico;
    @NotNull
    private Boolean intervencoesCirurgicas;
    @NotBlank
    private String consideracoesIntervencoesCirurgicas;
    @NotNull
    private Boolean alergias;
    @NotBlank
    private String consideracoesAlergias;

    private Praticante praticante;


}

