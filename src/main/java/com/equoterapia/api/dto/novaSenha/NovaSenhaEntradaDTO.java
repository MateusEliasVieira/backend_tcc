package com.equoterapia.api.dto.novaSenha;

import com.equoterapia.utilidades.Resposta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaSenhaEntradaDTO {

    @NotBlank
    private String token;

    @NotBlank(message = Resposta.SENHA_CADASTRO)
    @Size(min = 6, message = Resposta.SENHA)
    private String novaSenha;

}
