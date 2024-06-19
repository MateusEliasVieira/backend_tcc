package com.equoterapia.api.controlador;
import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.login.LoginEntradaDTO;
import com.equoterapia.api.dto.login.LoginSaidaDTO;
import com.equoterapia.api.mapeador.LoginMapeador;
import com.equoterapia.dominio.modelo.usuario.Usuario;
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
    private UsuarioService service;

    @Autowired
    public AuthenticationManager authenticationManager;
    private final int MAX_ATTEMPTS = 3;

    @PostMapping("/logar")
    public ResponseEntity<?> enter(@RequestBody @Valid LoginEntradaDTO loginEntradaDTO, HttpServletRequest request) {
        Mensagem message = new Mensagem();
        // creates a log of the login request
        Log.createSimpleLog(loginEntradaDTO, request);

        if (service.findUser(loginEntradaDTO.getNomeUsuario())) {
            if (service.attemptsUser(loginEntradaDTO.getNomeUsuario()) < MAX_ATTEMPTS) {
                return processLogin(loginEntradaDTO);
            } else {
                // At this point, we know that the allowed number of attempts has been exceeded
                // check if there is a waiting date for a new login attempt
                if (service.verifyReleaseDateLogin(loginEntradaDTO.getNomeUsuario())) {

                    // there is a lockout date for login
                    Date releaseDate = service.getDateReleaseLogin(loginEntradaDTO.getNomeUsuario());

                    // check if it is still valid
                    if (releaseDate.after(new Date(System.currentTimeMillis()))) {
                        // if it is not expired yet
                        message.setMensagem(Resposta.NOVA_TENTATIVA + FormataData.formateMinhaData(releaseDate));
                        return new ResponseEntity<Mensagem>(message, HttpStatus.LOCKED);
                    } else {
                        // time expired
                        service.resetAttemptsAndReleaseLogin(loginEntradaDTO.getNomeUsuario());
                        return processLogin(loginEntradaDTO);
                    }
                } else {
                    // If it doesn't exist, add the waiting time for a new login attempt for this user
                    Date releaseDate = service.releaseLogin(loginEntradaDTO.getNomeUsuario());
                    message.setMensagem(Resposta.TENTATIVAS_ESGOTADAS + FormataData.formateMinhaData(releaseDate));
                    return new ResponseEntity<Mensagem>(message, HttpStatus.LOCKED);
                }
            }
        }
        message.setMensagem(Resposta.LOGIN_INVALIDO);
        return new ResponseEntity<Mensagem>(message, HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<?> processLogin(LoginEntradaDTO loginEntradaDTO) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(loginEntradaDTO.getNomeUsuario(), loginEntradaDTO.getSenha());
            var auth = authenticationManager.authenticate(usernamePassword);
            // check login
            if (auth.isAuthenticated()) {
                // register login
                Usuario loggedInUser = service.login((Usuario) auth.getPrincipal());
                if (loggedInUser.isStatus()) {
                    // User active
                    return new ResponseEntity<LoginSaidaDTO>(LoginMapeador.mapperUsuarioParaLoginOutputDTO(loggedInUser), HttpStatus.ACCEPTED);
                }else{
                    System.out.println(loggedInUser.toString());
                }
            }
        } catch (AuthenticationException e) {
            // increment attempts
            service.updateAttempts(loginEntradaDTO.getNomeUsuario());
        }

        return new ResponseEntity<Mensagem>(new Mensagem(Resposta.LOGIN_INVALIDO), HttpStatus.NOT_ACCEPTABLE);
    }
}