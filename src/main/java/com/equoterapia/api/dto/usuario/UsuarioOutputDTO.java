package com.equoterapia.api.dto.usuario;

import com.equoterapia.dominio.enums.EstadoCivil;
import com.equoterapia.dominio.enums.Role;
import com.equoterapia.dominio.enums.Vinculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
