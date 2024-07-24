package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.EquilibrioEstaticoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquilibrioEstaticoEntradaDTO {

    // Equilíbrio Estático

    private Long idEquilibrioEstatico;
    private EquilibrioEstaticoEnum apoioCabeca;
    private String comentariosApoioCabeca;
    private EquilibrioEstaticoEnum sentarSemApoio;
    private String comentariosSentarSemApoio;
    private EquilibrioEstaticoEnum sentarComApoio;
    private String comentariosSentarComApoio;
    private EquilibrioEstaticoEnum emPeSemApoio;
    private String comentariosEmPeSemApoio;
    private EquilibrioEstaticoEnum emPeComApoio;
    private String comentariosEmPeComApoio;
    private EquilibrioEstaticoEnum posicaoDeSentinelaOlhosAbertos;
    private String comentariosPosicaoDeSentinelaOlhosAbertos;
    private EquilibrioEstaticoEnum posicaoDeSentinelaOlhosFechados;
    private String comentariosPosicaoDeSentinelaOlhosFechados;
    private EquilibrioEstaticoEnum umPeOlhosAbertos;
    private String comentariosUmPeOlhosAbertos;
    private EquilibrioEstaticoEnum umPeOlhosFechados;
    private String comentariosUmPeOlhosFechados;

    @NotNull
    private PraticanteIdDTO praticante;

}
