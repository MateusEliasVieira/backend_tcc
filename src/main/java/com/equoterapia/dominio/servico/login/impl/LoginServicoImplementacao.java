package com.equoterapia.dominio.servico.login.impl;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.login.LoginEntradaDTO;
import com.equoterapia.api.dto.login.LoginSaidaDTO;
import com.equoterapia.api.mapeador.login.LoginMapeador;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.servico.login.LoginServico;
import com.equoterapia.dominio.servico.usuario.UsuarioServico;
import com.equoterapia.utilidades.FormataData;
import com.equoterapia.utilidades.Log;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginServicoImplementacao implements LoginServico {

    @Autowired
    private UsuarioServico service;

    @Autowired
    public AuthenticationManager authenticationManager;
    private final int TENTATIVAS_MAXIMAS = 3;
    private Mensagem mensagem;

    @Override
    public ResponseEntity<?> filtrarLogin(LoginEntradaDTO loginEntradaDTO, HttpServletRequest request) {
        this.mensagem = new Mensagem();
        Log.registrarLog(loginEntradaDTO, request);
        if (service.verificarSeExisteUsuarioPorNomeDeUsuario(loginEntradaDTO.getNomeUsuario())) {
            if (service.buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(loginEntradaDTO.getNomeUsuario()) < TENTATIVAS_MAXIMAS) {
                return processarLogin(loginEntradaDTO);
            } else {
                return verificarDataDeLiberarLogin(loginEntradaDTO);
            }
        }
        this.mensagem.setMensagem("Login inválido!");
        return new ResponseEntity<Mensagem>(this.mensagem, HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<?> processarLogin(LoginEntradaDTO loginEntradaDTO) {
        try {
            var nomeDeUsuarioESenha = new UsernamePasswordAuthenticationToken(loginEntradaDTO.getNomeUsuario(), loginEntradaDTO.getSenha());
            var autenticacao = authenticationManager.authenticate(nomeDeUsuarioESenha);
            if (autenticacao.isAuthenticated()) {
                Usuario usuarioLogado = service.login((Usuario) autenticacao.getPrincipal());
                if (usuarioLogado.isStatus()) {
                    return new ResponseEntity<LoginSaidaDTO>(LoginMapeador.mapperUsuarioParaLoginOutputDTO(usuarioLogado), HttpStatus.ACCEPTED);
                }
            } else {
                service.atualizarTentativasErradasDeLogin(loginEntradaDTO.getNomeUsuario());
            }
        } catch (AuthenticationException e) {
            service.atualizarTentativasErradasDeLogin(loginEntradaDTO.getNomeUsuario());
        }
        return new ResponseEntity<Mensagem>(new Mensagem("Login inválido!"), HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<?> verificarDataDeLiberarLogin(LoginEntradaDTO loginEntradaDTO) {
        if (service.verificarDataLiberarLogin(loginEntradaDTO.getNomeUsuario())) {
            Date dataParaLiberar = service.getDataLiberarLogin(loginEntradaDTO.getNomeUsuario());
            if (dataParaLiberar != null) {
                if (dataParaLiberar.after(new Date(System.currentTimeMillis()))) {
                    this.mensagem.setMensagem("Nova tentativa será permitida em " + FormataData.formateMinhaData(dataParaLiberar));
                    return new ResponseEntity<Mensagem>(this.mensagem, HttpStatus.LOCKED);
                } else {
                    service.resetarTentativasELiberarLogin(loginEntradaDTO.getNomeUsuario());
                    return processarLogin(loginEntradaDTO);
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Erro interno do sistema!");
            }
        } else {
            return criarDataDeLiberacaoDeLogin(loginEntradaDTO);
        }
    }

    public ResponseEntity<Mensagem> criarDataDeLiberacaoDeLogin(LoginEntradaDTO loginEntradaDTO) {
        Date dataParaLiberar = service.atualizarDataParaNovaTentativaDeLogin(loginEntradaDTO.getNomeUsuario()); // aqui
        this.mensagem.setMensagem("Tentativas esgotadas, nova tentativa será permitida em " + FormataData.formateMinhaData(dataParaLiberar));
        return new ResponseEntity<Mensagem>(this.mensagem, HttpStatus.LOCKED);
    }

}
