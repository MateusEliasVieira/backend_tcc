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
public class CuidadosPessoais {

    // Cuidados pessoais

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuidadosPessoais;
    private PreencherLegenda higienePessoalSozinho;
    private PreencherLegenda vesteRoupasCalcadosSozinho;
    private PreencherLegenda seAlimentaSozinho;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}
