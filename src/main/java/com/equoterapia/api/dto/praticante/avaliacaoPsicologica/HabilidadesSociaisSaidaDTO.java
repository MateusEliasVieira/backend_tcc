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
    private PreencherLegendaEnum passividade;
    private PreencherLegendaEnum autoagressao;
    private PreencherLegendaEnum heteroagressividade;
    private PreencherLegendaEnum assertividade;


}

