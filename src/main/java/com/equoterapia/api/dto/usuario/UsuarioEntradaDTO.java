package com.equoterapia.api.dto.usuario;

import com.equoterapia.dominio.enums.EstadoCivil;
import com.equoterapia.dominio.enums.Role;
import com.equoterapia.dominio.enums.Vinculo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

import static com.equoterapia.utilidades.Resposta.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntradaDTO {

    @NotBlank
    @Size(min = 4, message = NOME_COMPLETO)
    private String nome;
    private String foto;
    @NotNull(message = DATA_NASCIMENTO)
    private Date dataNascimento;
    @NotNull
    @CPF
    private String cpf;
    @NotNull(message = ESTADO_CIVIL)
    private EstadoCivil estadoCivil;
    @NotBlank(message = TELEFONE)
    private String telefone;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 50, message = NOME_USUARIO)
    private String nomeUsuario;
    @NotBlank
    @Size(min = 6, max = 100, message = SENHA)
    private String senha;
    @Column(columnDefinition = "text")
    private String detalhesFormacao;
    @NotBlank(message = CIDADE)
    private String cidade;
    @NotBlank(message = BAIRRO)
    private String bairro;
    @NotBlank(message = LOGRADOURO)
    private String logradouro;
    @NotNull(message = TIPO_ROLE)
    private Role role;
    @NotNull(message = VINCULO)
    private Vinculo vinculo;
    @NotNull(message = POSSUI_FORMACAO)
    private Boolean possuiFormacao;


}
