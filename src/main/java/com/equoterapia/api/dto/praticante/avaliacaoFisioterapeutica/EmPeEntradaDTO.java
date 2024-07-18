package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmPeEntradaDTO {

    // Em Pe entrada dto

    private Long idEmPe;
    @NotNull
    private Boolean sequenciaDeMovimentos;
    @NotBlank
    private String consideracoesSequenciaDeMovimentos;
    @NotNull
    private Boolean entrarSairPosicaoSentadoChao;
    @NotBlank
    private String consideracoesEntrarSairPosicaoSentadoChao;
    @NotNull
    private Boolean sentadoCadeira;
    @NotBlank
    private String consideracoesSentadoCadeira;
    @NotNull
    private Boolean posturaEquilibrio;
    @NotBlank
    private String consideracoesPosturaEquilibrio;
    @NotNull
    private Boolean seqMovRolaSenta;
    @NotBlank
    private String consideracoesSeqMovRolaSenta;
    @NotNull
    private Boolean passaParaSentado;
    @NotBlank
    private String consideracoesPassaParaSentado;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

