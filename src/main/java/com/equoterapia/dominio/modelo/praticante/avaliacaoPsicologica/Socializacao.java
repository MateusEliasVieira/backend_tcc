package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegenda;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
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
    private Praticante paciente;

}

