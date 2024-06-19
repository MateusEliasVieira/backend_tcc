package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.CorOuRaca;
import com.equoterapia.domain.enums.Sexo;
import com.equoterapia.domain.enums.TipoSanguineo;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DadosPessoaisOutputDTO {

    // Dados Pessoais do Praticante

    private Long idDadosPessoais;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String diagnosticoClinico;
    @NotBlank
    private String queixaPrincipal; // Queixa principal (EX: dificuldade de concentração)
    @NotBlank
    private String cid;
    @NotNull
    private Date dataNascimento;
    @NotNull
    private Double peso;
    @Enumerated
    private TipoSanguineo tipoSanguineo;
    @NotBlank
    private String fatorRH;
    @NotNull
    private Double altura;
    @Enumerated
    private Sexo sexo;
    @NotBlank
    private String naturalidade;
    @Enumerated
    private CorOuRaca corOuRaca;
    @CPF
    private String cpf;
    @NotBlank
    private String cartaoSUS;
    @NotBlank
    private String enderecoResidencial;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;

    @NotNull
    private PacienteIdDTO paciente;

}

