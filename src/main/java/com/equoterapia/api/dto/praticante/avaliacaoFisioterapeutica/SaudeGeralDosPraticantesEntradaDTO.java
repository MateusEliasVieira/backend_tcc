package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeGeralDosPraticantesEntradaDTO {

    // Saúde geral do paciente

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

    @NotNull
    private PraticanteIdDTO praticante;


}

