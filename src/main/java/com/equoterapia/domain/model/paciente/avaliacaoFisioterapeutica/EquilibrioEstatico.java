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
public class EquilibrioEstatico {

    // Equilíbrio Estático

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquilibrioEstatico;
    private com.equoterapia.domain.enums.EquilibrioEstatico apoioCabeca;
    private String comentariosApoioCabeca;
    private com.equoterapia.domain.enums.EquilibrioEstatico sentarSemApoio;
    private String comentariosSentarSemApoio;
    private com.equoterapia.domain.enums.EquilibrioEstatico sentarComApoio;
    private String comentariosSentarComApoio;
    private com.equoterapia.domain.enums.EquilibrioEstatico emPeSemApoio;
    private String comentariosEmPeSemApoio;
    private com.equoterapia.domain.enums.EquilibrioEstatico emPeComApoio;
    private String comentariosEmPeComApoio;
    private com.equoterapia.domain.enums.EquilibrioEstatico posicaoDeSentinelaOlhosAbertos;
    private String comentariosPosicaoDeSentinelaOlhosAbertos;
    private com.equoterapia.domain.enums.EquilibrioEstatico posicaoDeSentinelaOlhosFechados;
    private String comentariosPosicaoDeSentinelaOlhosFechados;
    private com.equoterapia.domain.enums.EquilibrioEstatico umPeOlhosAbertos;
    private String comentariosUmPeOlhosAbertos;
    private com.equoterapia.domain.enums.EquilibrioEstatico umPeOlhosFechados;
    private String comentariosUmPeOlhosFechados;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}
