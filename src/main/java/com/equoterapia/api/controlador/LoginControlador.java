package com.equoterapia.api.controlador;

import com.equoterapia.api.dto.login.LoginEntradaDTO;
import com.equoterapia.dominio.servico.login.LoginServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginControlador {

    @Autowired
    private LoginServico servico;

    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody @Valid LoginEntradaDTO loginEntradaDTO, HttpServletRequest request) {
        return servico.filtrarLogin(loginEntradaDTO,request);
    }


}