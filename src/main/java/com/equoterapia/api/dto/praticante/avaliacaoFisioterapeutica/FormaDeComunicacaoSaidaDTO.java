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
public class FormaDeComunicacaoSaidaDTO {

    // Forma de comunicação

    private Long idFormaDeComunicacao;
    private SImOuNaoEnum fala;
    private String consideracoesFala;
    private SImOuNaoEnum gestos;
    private String consideracoesGestos;
    private SImOuNaoEnum usoDosOlhos;
    private String consideracoesUsoDosOlhos;

}

