package com.equoterapia.domain.model.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
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
public class OutrasAtividadesManha {

    // Cronograma de atividade do paciente em outras instituições período matutino

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOutrasAtividadesManha;
    private String segundaFeira;
    private String tercaFeira;
    private String quartaFeira;
    private String quintaFeira;
    private String sextaFeira;
    private String sabado;
    private String domingo;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}
