package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private SImOuNaoEnum testeMaoObjeto;
    private String consideracoesTesteMaoObjeto;
    private SImOuNaoEnum indiceNarizUnilateral;
    private String consideracoesIndiceNarizUnilateral;
    private SImOuNaoEnum testeIndiceIndice;
    private String consideracoesTesteIndiceIndice;
    private SImOuNaoEnum movimentosAlternados;
    private String consideracoesMovimentosAlternados;
    private SImOuNaoEnum testeAlcancePegar;
    private String consideracoesTesteAlcancePegar;

}

