package com.equoterapia.api.dto.login;

import com.equoterapia.dominio.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginSaidaDTO {

    @NotNull
    private Long idUsuario;
    @NotBlank
    private String nomeUsuario;
    @NotBlank
    private String token;
    private LocalDateTime validadeToken = LocalDateTime.now().plus(60, ChronoUnit.MINUTES);
    @NotNull
    private RoleEnum role;

}
