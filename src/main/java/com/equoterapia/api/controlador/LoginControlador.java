package com.equoterapia.api.controlador;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.login.LoginEntradaDTO;
import com.equoterapia.api.dto.login.LoginSaidaDTO;
import com.equoterapia.api.mapeador.LoginMapeador;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.servico.login.LoginServico;
import com.equoterapia.dominio.servico.usuario.UsuarioService;
import com.equoterapia.utilidades.Resposta;
import com.equoterapia.utilidades.FormataData;
import com.equoterapia.utilidades.Log;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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