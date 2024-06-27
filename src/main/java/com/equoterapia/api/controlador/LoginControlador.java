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
        Mensagem mensagem = new Mensagem();
        Log.registrarLog(loginEntradaDTO, request);
        if (service.verificarSeExisteUsuarioPorNomeDeUsuario(loginEntradaDTO.getNomeUsuario())) {
            if (service.atualizarTentativasErradasDeLogin(loginEntradaDTO.getNomeUsuario()) < MAX_ATTEMPTS) {
                return processarLogin(loginEntradaDTO);
            } else {

                if (service.verificarDataLiberarLogin(loginEntradaDTO.getNomeUsuario())) {
                    Date dataParaLiberar = service.getDataLiberarLogin(loginEntradaDTO.getNomeUsuario());
                    if (dataParaLiberar.after(new Date(System.currentTimeMillis()))) {
                        mensagem.setMensagem(Resposta.NOVA_TENTATIVA + FormataData.formateMinhaData(dataParaLiberar));
                        return new ResponseEntity<Mensagem>(mensagem, HttpStatus.LOCKED);
                    } else {
                        service.resetarTentativasELiberarLogin(loginEntradaDTO.getNomeUsuario());
                        return processarLogin(loginEntradaDTO);
                    }
                } else {
                    Date dataParaLiberar = service.getDataLiberarLogin(loginEntradaDTO.getNomeUsuario());
                    mensagem.setMensagem(Resposta.TENTATIVAS_ESGOTADAS + FormataData.formateMinhaData(dataParaLiberar));
                    return new ResponseEntity<Mensagem>(mensagem, HttpStatus.LOCKED);
                }
            }
        }
        mensagem.setMensagem(Resposta.LOGIN_INVALIDO);
        return new ResponseEntity<Mensagem>(mensagem, HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<?> processarLogin(LoginEntradaDTO loginEntradaDTO) {
        try {
            var nomeDeUsuarioESenha = new UsernamePasswordAuthenticationToken(loginEntradaDTO.getNomeUsuario(), loginEntradaDTO.getSenha());
            var autenticacao = authenticationManager.authenticate(nomeDeUsuarioESenha);
            if (autenticacao.isAuthenticated()) {
                Usuario usuarioLogado = service.login((Usuario) autenticacao.getPrincipal());
                if (usuarioLogado.isStatus()) {
                    return new ResponseEntity<LoginSaidaDTO>(LoginMapeador.mapperUsuarioParaLoginOutputDTO(usuarioLogado), HttpStatus.ACCEPTED);
                }
            }
        } catch (AuthenticationException e) {
            service.atualizarTentativasErradasDeLogin(loginEntradaDTO.getNomeUsuario());
        }
        return new ResponseEntity<Mensagem>(new Mensagem(Resposta.LOGIN_INVALIDO), HttpStatus.NOT_ACCEPTABLE);
    }
}