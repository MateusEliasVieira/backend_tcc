package com.equoterapia.api.controlador.recuperacao;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.dominio.servico.recuperacao.RecuperacaoServico;
import com.equoterapia.dominio.servico.usuario.UsuarioServico;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/recuperacao-de-conta")
public class RecuperacaoDeContaControlador {

    @Autowired
    private RecuperacaoServico recuperacaoServico;

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping("/enviar-email/{email}")
    public ResponseEntity<Mensagem> recuperarConta(@PathVariable("email") @Email String email) {
        System.out.println("Email chegou aqui = "+email);
        recuperacaoServico.recuperarConta(email);
        return new ResponseEntity<Mensagem>(new Mensagem("Email enviado com sucesso!"), HttpStatus.OK);
    }
}
