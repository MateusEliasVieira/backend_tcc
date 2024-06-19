package com.equoterapia.api.dto.login;

import com.equoterapia.domain.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginOutputDTO {

    @NotNull
    private Long idUsuario;
    @NotBlank
    private String nomeUsuario;
    @NotBlank
    private String token;
    @NotNull
    private Role role;

}
