package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.CorOuRaca;
import com.equoterapia.dominio.enums.SexoEnum;
import com.equoterapia.dominio.enums.TipoSanguineoEnum;
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
public class DadosPessoaisSaidaDTO {

    // Dados Pessoais do Praticante

    private Long idDadosPessoais;
    private String nomeCompleto;
    private String diagnosticoClinico;
    private String queixaPrincipal; // Queixa principal (EX: dificuldade de concentração)
    private String cid;
    private Date dataNascimento;
    private Double peso;
    private TipoSanguineoEnum tipoSanguineo;
    private String fatorRH;
    private Double altura;
    private SexoEnum sexo;
    private String naturalidade;
    private CorOuRaca corOuRaca;
    private String cpf;
    private String cartaoSUS;
    private String enderecoResidencial;
    private String bairro;
    private String cidade;
    private String cep;

}

