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
public class FormaDeComunicacao {

    // Forma de comunicação

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormaDeComunicacao;
    private Boolean fala;
    private String consideracoesFala;
    private Boolean gestos;
    private String consideracoesGestos;
    private Boolean usoDosOlhos;
    private String consideracoesUsoDosOlhos;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

