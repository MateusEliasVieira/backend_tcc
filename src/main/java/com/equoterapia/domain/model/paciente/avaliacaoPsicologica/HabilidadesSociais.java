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
public class HabilidadesSociais {

    // Habilidades sociais

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidadesSociais;
    private PreencherLegenda passividade;
    private PreencherLegenda autoagressao;
    private PreencherLegenda heteroagressividade;
    private PreencherLegenda assertividade;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;
}

