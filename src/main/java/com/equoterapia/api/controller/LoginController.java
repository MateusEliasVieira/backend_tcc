package com.equoterapia.api.controller;
import com.equoterapia.api.controller.utils.Mensagem;
import com.equoterapia.api.dto.login.LoginInputDTO;
import com.equoterapia.api.dto.login.LoginOutputDTO;
import com.equoterapia.api.mapper.LoginMapper;
import com.equoterapia.domain.model.usuario.Usuario;
import com.equoterapia.domain.service.usuario.UsuarioService;
import com.equoterapia.utils.Feedback;
import com.equoterapia.utils.FormataData;
import com.equoterapia.utils.Log;
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
public class LoginController {

    @Autowired
    private UsuarioService service;

    @Autowired
    public AuthenticationManager authenticationManager;
    private final int MAX_ATTEMPTS = 3;

    @PostMapping("/logar")
    public ResponseEntity<?> enter(@RequestBody @Valid LoginInputDTO loginInputDTO, HttpServletRequest request) {
        Mensagem message = new Mensagem();
        // creates a log of the login request
        Log.createSimpleLog(loginInputDTO, request);

        if (service.findUser(loginInputDTO.getNomeUsuario())) {
            if (service.attemptsUser(loginInputDTO.getNomeUsuario()) < MAX_ATTEMPTS) {
                return processLogin(loginInputDTO);
            } else {
                // At this point, we know that the allowed number of attempts has been exceeded
                // check if there is a waiting date for a new login attempt
                if (service.verifyReleaseDateLogin(loginInputDTO.getNomeUsuario())) {

                    // there is a lockout date for login
                    Date releaseDate = service.getDateReleaseLogin(loginInputDTO.getNomeUsuario());

                    // check if it is still valid
                    if (releaseDate.after(new Date(System.currentTimeMillis()))) {
                        // if it is not expired yet
                        message.setMensagem(Feedback.NOVA_TENTATIVA + FormataData.formateMinhaData(releaseDate));
                        return new ResponseEntity<Mensagem>(message, HttpStatus.LOCKED);
                    } else {
                        // time expired
                        service.resetAttemptsAndReleaseLogin(loginInputDTO.getNomeUsuario());
                        return processLogin(loginInputDTO);
                    }
                } else {
                    // If it doesn't exist, add the waiting time for a new login attempt for this user
                    Date releaseDate = service.releaseLogin(loginInputDTO.getNomeUsuario());
                    message.setMensagem(Feedback.TENTATIVAS_ESGOTADAS + FormataData.formateMinhaData(releaseDate));
                    return new ResponseEntity<Mensagem>(message, HttpStatus.LOCKED);
                }
            }
        }
        message.setMensagem(Feedback.LOGIN_INVALIDO);
        return new ResponseEntity<Mensagem>(message, HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<?> processLogin(LoginInputDTO loginInputDTO) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(loginInputDTO.getNomeUsuario(), loginInputDTO.getSenha());
            var auth = authenticationManager.authenticate(usernamePassword);
            // check login
            if (auth.isAuthenticated()) {
                // register login
                Usuario loggedInUser = service.login((Usuario) auth.getPrincipal());
                if (loggedInUser.isStatus()) {
                    // User active
                    return new ResponseEntity<LoginOutputDTO>(LoginMapper.mapperUsuarioParaLoginOutputDTO(loggedInUser), HttpStatus.ACCEPTED);
                }else{
                    System.out.println(loggedInUser.toString());
                }
            }
        } catch (AuthenticationException e) {
            // increment attempts
            service.updateAttempts(loginInputDTO.getNomeUsuario());
        }

        return new ResponseEntity<Mensagem>(new Mensagem(Feedback.LOGIN_INVALIDO), HttpStatus.NOT_ACCEPTABLE);
    }
}