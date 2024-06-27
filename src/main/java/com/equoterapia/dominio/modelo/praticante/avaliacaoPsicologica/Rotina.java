package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

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
public class Rotina {

    // Rotina

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRotina;
    private String brincadeiras;
    private String preferenciasPorBrincadeiras;
    private Boolean aceitaMudancasNaRotina;
    private String consideracoesSobreRotina;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

