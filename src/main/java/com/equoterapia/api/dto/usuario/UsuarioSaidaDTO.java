package com.equoterapia.api.dto.usuario;

import com.equoterapia.dominio.enums.EstadoCivilEnum;
import com.equoterapia.dominio.enums.RoleEnum;
import com.equoterapia.dominio.enums.VinculoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSaidaDTO {

    private Long idUsuario;
    private String nome;
    private String foto;
    private Date dataNascimento;
    private String cpf;
    private EstadoCivilEnum estadoCivil;
    private String telefone;
    private String email;
    private String detalhesFormacao;
    private String cidade;
    private String bairro;
    private String logradouro;
    private RoleEnum role;
    private VinculoEnum vinculo;
    private Boolean possuiFormacao;

}
