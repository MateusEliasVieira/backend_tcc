package com.equoterapia.api.dto.login;

import com.equoterapia.utils.Feedback;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginInputDTO {

    @NotBlank(message = Feedback.NOME_USUARIO_LOGIN)
    private String nomeUsuario;
    @NotBlank(message = Feedback.SENHA_LOGIN)
    @Size(min = 6, message = Feedback.SENHA)
    private String senha;

}
