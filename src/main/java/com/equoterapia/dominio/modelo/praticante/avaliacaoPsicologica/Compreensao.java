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
public class Compreensao {

    // Compreensão

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompreensao;
    private PreencherLegenda compreendeOrdens;
    private PreencherLegenda executaOrdensVerbaisSimples;
    private PreencherLegenda executaOrdensComplexas;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Praticante paciente;

}

