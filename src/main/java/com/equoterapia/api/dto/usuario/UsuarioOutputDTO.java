package com.equoterapia.api.dto.usuario;

import com.equoterapia.domain.enums.EstadoCivil;
import com.equoterapia.domain.enums.Role;
import com.equoterapia.domain.enums.Vinculo;
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

import static com.equoterapia.utils.Feedback.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDTO {

    private Long idUsuario;
    private String nome;
    private String foto;
    private Date dataNascimento;
    private String cpf;
    private EstadoCivil estadoCivil;
    private String telefone;
    private String email;
    private String detalhesFormacao;
    private String cidade;
    private String bairro;
    private String logradouro;
    private Role role;
    private Vinculo vinculo;
    private Boolean possuiFormacao;

}
