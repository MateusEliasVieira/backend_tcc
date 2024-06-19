package com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.model.paciente.Paciente;
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
@Entity
public class HabilidadesMotorasAVD {

    // Habilidades Motoras/AVD's

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

