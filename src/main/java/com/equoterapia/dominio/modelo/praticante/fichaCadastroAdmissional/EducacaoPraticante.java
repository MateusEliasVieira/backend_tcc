package com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.enums.*;
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
public class EducacaoPraticante {

    // Escolaridade do paciente

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducacaoPraticante;
    private String serieEscolar;
    private ClasseDeEscola classeDeEscola;
    private String instituicaoEducacional;
    private TipoDeInstituicaoEducacionalEnum tipoDeInstituicaoEducacional;
    private PeriodoEnum periodo;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

