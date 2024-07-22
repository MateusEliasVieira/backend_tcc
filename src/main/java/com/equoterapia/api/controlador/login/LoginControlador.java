package com.equoterapia.api.controlador.login;

import com.equoterapia.api.dto.login.LoginEntradaDTO;
import com.equoterapia.api.dto.login.LoginSaidaDTO;
import com.equoterapia.dominio.servico.login.LoginServico;
import io.swagger.oas.annotations.Operation;
import io.swagger.oas.annotations.media.Content;
import io.swagger.oas.annotations.media.Schema;
import io.swagger.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginControlador {

    @Autowired
    private LoginServico servico;

    @Operation(summary = "Realizar login", description = "Realiza login com nome de usuário e senha", method = "POST", responses = {
            @ApiResponse(description = "Login realizado com sucesso!", responseCode = "202", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = LoginSaidaDTO.class))),
            @ApiResponse(description = "Login inválido!", responseCode = "406", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody @Valid LoginEntradaDTO loginEntradaDTO, HttpServletRequest request) {
        return servico.filtrarLogin(loginEntradaDTO,request);
    }


}