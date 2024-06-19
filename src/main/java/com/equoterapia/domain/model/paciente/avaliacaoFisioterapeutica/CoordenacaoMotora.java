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
public class CoordenacaoMotora {

    // Coordenação Motora

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordenacaoMotora;
    private Boolean testeMaoObjeto;
    private String consideracoesTesteMaoObjeto;
    private Boolean indiceNarizUnilateral;
    private String consideracoesIndiceNarizUnilateral;
    private Boolean testeIndiceIndice;
    private String consideracoesTesteIndiceIndice;
    private Boolean movimentosAlternados;
    private String consideracoesMovimentosAlternados;
    private Boolean testeAlcancePegar;
    private String consideracoesTesteAlcancePegar;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

