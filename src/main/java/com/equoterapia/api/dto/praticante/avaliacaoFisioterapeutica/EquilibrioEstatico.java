package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

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
    private com.equoterapia.dominio.enums.EquilibrioEstatico apoioCabeca;
    @NotBlank
    private String comentariosApoioCabeca;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico sentarSemApoio;
    @NotBlank
    private String comentariosSentarSemApoio;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico sentarComApoio;
    @NotBlank
    private String comentariosSentarComApoio;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico emPeSemApoio;
    @NotBlank
    private String comentariosEmPeSemApoio;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico emPeComApoio;
    @NotBlank
    private String comentariosEmPeComApoio;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico posicaoDeSentinelaOlhosAbertos;
    @NotBlank
    private String comentariosPosicaoDeSentinelaOlhosAbertos;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico posicaoDeSentinelaOlhosFechados;
    @NotBlank
    private String comentariosPosicaoDeSentinelaOlhosFechados;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico umPeOlhosAbertos;
    @NotBlank
    private String comentariosUmPeOlhosAbertos;
    @Enumerated
    @NotNull
    private com.equoterapia.dominio.enums.EquilibrioEstatico umPeOlhosFechados;
    @NotBlank
    private String comentariosUmPeOlhosFechados;


    private Praticante praticante;

}
