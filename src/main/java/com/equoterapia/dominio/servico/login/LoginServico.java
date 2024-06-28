package com.equoterapia.dominio.servico.login;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.login.LoginEntradaDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface LoginServico {

    public ResponseEntity<?> filtrarLogin(LoginEntradaDTO loginEntradaDTO, HttpServletRequest request);
    public ResponseEntity<?> processarLogin(LoginEntradaDTO loginEntradaDTO);
    public ResponseEntity<?> criarDataDeLiberacaoDeLogin(LoginEntradaDTO loginEntradaDTO);
    public ResponseEntity<?> verificarDataDeLiberarLogin(LoginEntradaDTO loginEntradaDTO);
}
