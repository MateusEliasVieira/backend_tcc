package com.equoterapia.api.dto.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FormaDeComunicacao {

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


    private Paciente paciente;

}

