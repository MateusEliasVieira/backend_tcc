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
    private Praticante paciente;
}
