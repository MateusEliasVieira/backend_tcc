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
public class CoordenacaoMotora {

    // Coordenação Motora

    private Long idCoordenacaoMotora;
    @NotNull
    private Boolean testeMaoObjeto;
    @NotBlank
    private String consideracoesTesteMaoObjeto;
    @NotNull
    private Boolean indiceNarizUnilateral;
    @NotBlank
    private String consideracoesIndiceNarizUnilateral;
    @NotNull
    private Boolean testeIndiceIndice;
    @NotBlank
    private String consideracoesTesteIndiceIndice;
    @NotNull
    private Boolean movimentosAlternados;
    @NotBlank
    private String consideracoesMovimentosAlternados;
    @NotNull
    private Boolean testeAlcancePegar;
    @NotBlank
    private String consideracoesTesteAlcancePegar;


    private Praticante praticante;

}

