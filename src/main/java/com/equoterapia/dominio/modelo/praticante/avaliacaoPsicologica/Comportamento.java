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
public class Comportamento {

    // Comportamento

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComportamento;
    private PreencherLegenda agitacao;
    private PreencherLegenda toleranciaFrustracao;
    private PreencherLegenda respeitaLimitesRegras;
    private PreencherLegenda oposicao;
    private PreencherLegenda atencaoConcentracao;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Praticante paciente;

}
