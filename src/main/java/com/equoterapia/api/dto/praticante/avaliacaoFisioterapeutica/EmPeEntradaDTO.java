package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmPeEntradaDTO {

    // Em Pe entrada dto

    private Long idEmPe;
    private Boolean sequenciaDeMovimentos;
    private String consideracoesSequenciaDeMovimentos;
    private Boolean entrarSairPosicaoSentadoChao;
    private String consideracoesEntrarSairPosicaoSentadoChao;
    private Boolean sentadoCadeira;
    private String consideracoesSentadoCadeira;
    private Boolean posturaEquilibrio;
    private String consideracoesPosturaEquilibrio;
    private Boolean seqMovRolaSenta;
    private String consideracoesSeqMovRolaSenta;
    private Boolean passaParaSentado;
    private String consideracoesPassaParaSentado;
    private String observacoes;

    @NotNull
    private PraticanteIdDTO praticante;

}

