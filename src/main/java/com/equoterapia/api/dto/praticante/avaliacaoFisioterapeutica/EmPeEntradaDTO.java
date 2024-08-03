package com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.SImOuNaoEnum;
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
    private SImOuNaoEnum sequenciaDeMovimentos;
    private String consideracoesSequenciaDeMovimentos;
    private SImOuNaoEnum entrarSairPosicaoSentadoChao;
    private String consideracoesEntrarSairPosicaoSentadoChao;
    private SImOuNaoEnum sentadoCadeira;
    private String consideracoesSentadoCadeira;
    private SImOuNaoEnum posturaEquilibrio;
    private String consideracoesPosturaEquilibrio;
    private SImOuNaoEnum seqMovRolaSenta;
    private String consideracoesSeqMovRolaSenta;
    private SImOuNaoEnum passaParaSentado;
    private String consideracoesPassaParaSentado;
    private String observacoes;

    @NotNull
    private PraticanteIdDTO praticante;

}

