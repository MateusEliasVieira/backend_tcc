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
public class HabilidadesMotorasAVDSaidaDTO {

    // Habilidades Motoras/AVD's

    private Long idHabilidadesMotorasAVD;
    private Boolean alcancarObjetos;
    private String consideracoesAlcancarObjetos;
    private Boolean usoBimanual;
    private String consideracoesUsoBimanual;
    private Boolean alimentacaoIndependente;
    private String consideracoesAlimentacaoIndependente;
    private Boolean vestirIndependente;
    private String consideracoesVestirIndependente;
    private Boolean pegarObjetos;
    private String consideracoesPegarObjetos;
    private Boolean negligenciaMembro;
    private String consideracoesNegligenciaMembro;
    private Boolean higienePessoal;
    private String consideracoesHigienePessoal;
    private Boolean andar;
    private String consideracoesAndar;
    private Boolean escritaManual;
    private String consideracoesEscritaManual;

}

