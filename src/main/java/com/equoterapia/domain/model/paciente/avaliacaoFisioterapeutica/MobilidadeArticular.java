package com.equoterapia.domain.model.patient.physicalTherapyAssessment;

import com.equoterapia.domain.model.paciente.Paciente;
import com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica;
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
public class MobilidadeArticular {

    // Mobilidade articular

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMobilidadeArticular;

    // Ombro (Shoulder)
    private String flexaoAtivaOmbro;
    private String flexaoPassivaOmbro;
    private String abducaoAtivaOmbro;

    private String abducaoPassivaOmbro;
    private String aducaoAtivaOmbro;
    private String aducaoPassivaOmbro;

    // Cotovelo (Elbow)
    private String flexaoAtivaCotovelo;
    private String flexaoPassivaCotovelo;
    private String extensaoAtivaCotovelo;
    private String extensaoPassivaCotovelo;

    // Quadril (Hip)
    private String flexaoAtivaQuadril;
    private String flexaoPassivaQuadril;
    private String extensaoAtivaQuadril;
    private String extensaoPassivaQuadril;
    private String aducaoAtivaQuadril;
    private String aducaoPassivaQuadril;
    private String abducaoAtivaQuadril;
    private String abducaoPassivaQuadril;
    private String rotacaoInternaAtivaQuadril;
    private String rotacaoInternaPassivaQuadril;
    private String rotacaoExternaAtivaQuadril;
    private String rotacaoExternaPassivaQuadril;

    // Joelho (Knee)
    private String extensaoAtivaJoelho;
    private String extensaoPassivaJoelho;
    private String flexaoAtivaJoelho;
    private String flexaoPassivaJoelho;

    // Tornozelo (Ankle)
    private String dorsiflexaoAtivaTornozelo;
    private String dorsiflexaoPassivaTornozelo;
    private String flexaoPlantarAtivaTornozelo;
    private String flexaoPlantarPassivaTornozelo;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;
}

