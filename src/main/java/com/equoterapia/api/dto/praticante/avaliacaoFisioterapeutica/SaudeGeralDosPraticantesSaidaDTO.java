package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaudeGeralDosPraticantesSaidaDTO {

    // Saúde geral do paciente

    private Long idSaudeGeralDosPacientes;
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

}

