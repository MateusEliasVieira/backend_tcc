package com.equoterapia.api.dto.login;

import com.equoterapia.utilidades.Resposta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginEntradaDTO {

    @NotBlank(message = Resposta.NOME_USUARIO_LOGIN)
    private String nomeUsuario;
    @NotBlank(message = Resposta.SENHA_LOGIN)
    @Size(min = 6, message = Resposta.SENHA)
    private String senha;

}
