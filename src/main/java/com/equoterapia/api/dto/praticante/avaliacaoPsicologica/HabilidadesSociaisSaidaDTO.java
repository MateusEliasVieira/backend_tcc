package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabilidadesSociaisSaidaDTO {

    // Habilidades sociais

    private Long idHabilidadesSociais;
    @Enumerated @NotBlank
    private PreencherLegendaEnum passividade;
    @Enumerated @NotBlank
    private PreencherLegendaEnum autoagressao;
    @Enumerated @NotBlank
    private PreencherLegendaEnum heteroagressividade;
    @Enumerated @NotBlank
    private PreencherLegendaEnum assertividade;


    private Praticante praticante;

}

