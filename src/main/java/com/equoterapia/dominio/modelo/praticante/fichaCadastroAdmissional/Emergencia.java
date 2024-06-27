package com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional;

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
public class Emergencia {

    // Emergência

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmergencia;
    private String ligarPara;
    @Column(unique = true)
    private String telefone;
    private Boolean possuiPlanoDeSaude;
    private String plano; // Caso tenha, qual é?

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
