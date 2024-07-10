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
public class FormaDeComunicacaoSaidaDTO {

    // Forma de comunicação

    private Long idFormaDeComunicacao;
    private Boolean fala;
    private String consideracoesFala;
    private Boolean gestos;
    private String consideracoesGestos;
    private Boolean usoDosOlhos;
    private String consideracoesUsoDosOlhos;

}

