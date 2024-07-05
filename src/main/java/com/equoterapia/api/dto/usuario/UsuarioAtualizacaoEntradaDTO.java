package com.equoterapia.api.dto.usuario;

import com.equoterapia.dominio.enums.EstadoCivilEnum;
import com.equoterapia.dominio.enums.RoleEnum;
import com.equoterapia.dominio.enums.VinculoEnum;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

import static com.equoterapia.utilidades.Resposta.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioAtualizacaoEntradaDTO {

    @NotNull
    private Long idUsuario;
    @NotBlank(message = NOME_COMPLETO)
    @Size(min = 4)
    private String nome;
    private String foto;
    @NotNull(message = DATA_NASCIMENTO)
    private Date dataNascimento;
    @NotNull
    @CPF
    private String cpf;
    @NotNull(message = ESTADO_CIVIL)
    private EstadoCivilEnum estadoCivil;
    @NotBlank(message = TELEFONE)
    private String telefone;
    @NotBlank
    @Email
    private String email;
    @Column(columnDefinition = "text")
    private String detalhesFormacao;
    @NotBlank(message = CIDADE)
    private String cidade;
    @NotBlank(message = BAIRRO)
    private String bairro;
    @NotBlank(message = LOGRADOURO)
    private String logradouro;
    @NotNull(message = TIPO_ROLE)
    private RoleEnum role;
    @NotNull(message = VINCULO)
    private VinculoEnum vinculo;
    @NotNull(message = POSSUI_FORMACAO)
    private Boolean possuiFormacao;


}
