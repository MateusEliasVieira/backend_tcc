package com.equoterapia.domain.model.paciente;

import com.equoterapia.domain.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    // Avaliação Fisioterapeutica
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica avaliacaoFisioterapeutica;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.CoordenacaoMotora coordenacaoMotora;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.EquilibrioDinamico equilibrioDinamico;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.EquilibrioEstatico equilibrioEstatico;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.FormaDeComunicacao formaDeComunicacao;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.patient.physicalTherapyAssessment.GruposMusculares gruposMusculares;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.HabilidadesMotorasAVD habilidadesMotorasAVD;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.patient.physicalTherapyAssessment.MobilidadeArticular mobilidadeArticular;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.QuadroAtual quadroAtual;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica.SaudeGeralDosPacientes saudeGeralDosPacientes;

    // Avaliação Psicológica
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Afetividade afetividade;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.AvaliacaoPsicologica avaliacaoPsicologica;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Comportamento comportamento;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Compreensao compreensao;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.CuidadosPessoais cuidadosPessoais;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.HabilidadesSociais habilidadesSociais;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Linguagem linguagem;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.RelacaoFamiliarExaminado relacaoFamiliarExaminado;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Rotina rotina;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Saude saude;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.SaudeMental saudeMental;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.SobreACrianca sobreACrianca;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.Socializacao socializacao;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.avaliacaoPsicologica.TracosDePersonalidade tracosDePersonalidade;

    // Ficha Cadastro Admissional
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.CompletudeMatricula completudeMatricula;
    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.DadosPessoais dadosPessoais;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.EducacaoPaciente educacaoPaciente;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.Emergencia emergencia;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.FichaCadastroAdmissional fichaCadastroAdmissional;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.OutrasAtividadesManha outrasAtividadesManha;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.OutrasAtividadesTarde outrasAtividadesTarde;
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.ResponsavelPaciente responsavelPaciente;

    // Plano Terapeutico Singular
    @OneToOne(mappedBy = "paciente")
    private com.equoterapia.domain.model.paciente.planoTerapeuticoSingular.PlanoTerapeuticoSingular planoTerapeuticoSingular;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;


    // Ficha Cadastro Admissional

    // Plano Terapeutico Singular


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
