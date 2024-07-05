package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.EquilibrioEstaticoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquilibrioEstatico {

    // Equilíbrio Estático


    private Long idEquilibrioEstatico;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum apoioCabeca;
    @NotBlank
    private String comentariosApoioCabeca;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum sentarSemApoio;
    @NotBlank
    private String comentariosSentarSemApoio;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum sentarComApoio;
    @NotBlank
    private String comentariosSentarComApoio;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum emPeSemApoio;
    @NotBlank
    private String comentariosEmPeSemApoio;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum emPeComApoio;
    @NotBlank
    private String comentariosEmPeComApoio;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum posicaoDeSentinelaOlhosAbertos;
    @NotBlank
    private String comentariosPosicaoDeSentinelaOlhosAbertos;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum posicaoDeSentinelaOlhosFechados;
    @NotBlank
    private String comentariosPosicaoDeSentinelaOlhosFechados;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum umPeOlhosAbertos;
    @NotBlank
    private String comentariosUmPeOlhosAbertos;
    @Enumerated
    @NotNull
    private EquilibrioEstaticoEnum umPeOlhosFechados;
    @NotBlank
    private String comentariosUmPeOlhosFechados;


    private Praticante praticante;

}
