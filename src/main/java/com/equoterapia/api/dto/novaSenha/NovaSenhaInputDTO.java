package com.equoterapia.api.dto.novaSenha;

import com.equoterapia.utils.Feedback;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaSenhaInputDTO {

    @NotBlank
    private String token;

    @NotBlank(message = Feedback.SENHA_CADASTRO)
    @Size(min = 6, message = Feedback.SENHA)
    private String novaSenha;

}
