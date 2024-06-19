package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
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
public class TracosDePersonalidade {

    // Traços de personalidade

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTracosDePersonalidade;
    private PreencherLegenda extroversao;
    private PreencherLegenda fobia;
    private PreencherLegenda obsessao;
    private PreencherLegenda introversao;
    private PreencherLegenda ansiedade;
    private PreencherLegenda histeria;
    private PreencherLegenda dependenciaEmocional;
    private PreencherLegenda timidez;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;
}
