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
public class CoordenacaoMotoraSaidaDTO {

    // Coordenação Motora

    private Long idCoordenacaoMotora;
    private Boolean testeMaoObjeto;
    private String consideracoesTesteMaoObjeto;
    private Boolean indiceNarizUnilateral;
    private String consideracoesIndiceNarizUnilateral;
    private Boolean testeIndiceIndice;
    private String consideracoesTesteIndiceIndice;
    private Boolean movimentosAlternados;
    private String consideracoesMovimentosAlternados;
    private Boolean testeAlcancePegar;
    private String consideracoesTesteAlcancePegar;

}

