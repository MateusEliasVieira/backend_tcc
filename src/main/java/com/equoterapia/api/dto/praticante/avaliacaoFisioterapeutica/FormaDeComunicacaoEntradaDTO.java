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
public class FormaDeComunicacaoEntradaDTO {

    // Forma de comunicação

    private Long idFormaDeComunicacao;
    @NotNull
    private Boolean fala;
    @NotBlank
    private String consideracoesFala;
    @NotNull
    private Boolean gestos;
    @NotBlank
    private String consideracoesGestos;
    @NotNull
    private Boolean usoDosOlhos;
    @NotBlank
    private String consideracoesUsoDosOlhos;

    @NotNull
    private PraticanteIdDTO praticante;

}

