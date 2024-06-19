package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Socializacao {

    // Socialização

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocializacao;
    private PreencherLegenda interageBemComOutrasCriancas;
    private PreencherLegenda interageBemComAdultos;
    private PreencherLegenda buscaContatoSocial;
    private PreencherLegenda temOportunidadeContato;
    private PreencherLegenda fazContatoVisual;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

