package com.equoterapia.api.controlador.usuario;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.usuario.UsuarioEntradaDTO;

import com.equoterapia.api.dto.usuario.UsuarioSaidaDTO;
import com.equoterapia.api.dto.usuario.UsuarioAtualizacaoEntradaDTO;
import com.equoterapia.api.mapeador.usuario.UsuarioMapeador;

import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.servico.usuario.UsuarioServico;
import com.equoterapia.utilidades.Resposta;
import com.equoterapia.utilidades.ValidadorDeSenha;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServico usuarioServico;

    @PostMapping("/salvar-novo-usuario")
    public ResponseEntity<Mensagem> salvarNovoUsuario(@RequestBody @Valid UsuarioEntradaDTO usuarioEntradaDTO) {
        ValidadorDeSenha.isStrong(usuarioEntradaDTO.getSenha());
        usuarioServico.salvar(UsuarioMapeador.converterUsuarioEntradaDTOEmUsuario(usuarioEntradaDTO));
        return new ResponseEntity<Mensagem>(new Mensagem(Resposta.USUARIO_CAD_OK), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar-usuario")
    public ResponseEntity<?> deletarUsuario(@RequestParam("id") Long id){
        usuarioServico.deletarUsuarioPorId(id);
        return new ResponseEntity<Mensagem>(new Mensagem("Usuário deletado com sucesso!"), HttpStatus.OK);
    }

    @PutMapping("/atualizar-usuario")
    public ResponseEntity<Mensagem> atualizarUsuario(@RequestBody @Valid UsuarioAtualizacaoEntradaDTO usuarioAtualizacaoEntradaDTO) {
        usuarioServico.atualizarUsuario(UsuarioMapeador.converterUsuarioUpdateEntradaDTOEmUsuario(usuarioAtualizacaoEntradaDTO));
        return new ResponseEntity<Mensagem>(new Mensagem(Resposta.USUARIO_UP_OK), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-usuario-por-nome")
    public ResponseEntity<?> pesquisarUsuarioPorNome(@RequestParam("nome") @Valid @NotBlank String nome) {
        List<Usuario> listUsuario = usuarioServico.pesquisarUsuarioPorNomeComOperadorLike(nome);
        return new ResponseEntity<List<UsuarioSaidaDTO>>(UsuarioMapeador.converterListaUsuarioEmListaUsuarioSaidaDTO(listUsuario), HttpStatus.OK);
    }

    @GetMapping("/buscar-usuario-por-id")
    public ResponseEntity<?> pesquisarUsuarioPorID(@RequestParam("id") Long id) {
        Usuario usuario = usuarioServico.buscarUsuarioPorId(id);
        return new ResponseEntity<UsuarioSaidaDTO>(UsuarioMapeador.converterUsuarioEmUsuarioSaidaDTO(usuario), HttpStatus.OK);
    }

}
