package com.equoterapia.api.controlador.recuperacao;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.novaSenha.NovaSenhaEntradaDTO;
import com.equoterapia.dominio.servico.recuperacao.RecuperacaoServico;
import com.equoterapia.dominio.servico.usuario.UsuarioServico;
import com.equoterapia.utilidades.ValidadorDeSenha;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/recuperacao-de-conta")
public class RecuperacaoDeContaControlador {

    @Autowired
    private RecuperacaoServico recuperacaoServico;

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping("/enviar-email/{email}")
    public ResponseEntity<Mensagem> recuperarConta(@PathVariable("email") @Email String email) {
        recuperacaoServico.recuperarConta(email);
        return new ResponseEntity<Mensagem>(new Mensagem("Email enviado com sucesso!"), HttpStatus.OK);
    }

    @PostMapping("/nova-senha")
    public ResponseEntity<Mensagem> newPassword(@RequestBody NovaSenhaEntradaDTO novaSenhaEntradaDTO) {
        ValidadorDeSenha.isStrong(novaSenhaEntradaDTO.getNovaSenha());
        usuarioServico.atualizarSenha(novaSenhaEntradaDTO);
        return new ResponseEntity<Mensagem>(new Mensagem("Nova senha atualizada com sucesso!"), HttpStatus.OK);
    }
}
