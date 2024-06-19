package com.equoterapia.api.controlador.usuario;

import com.equoterapia.api.controlador.utilidades.Mensagem;
import com.equoterapia.api.dto.usuario.UsuarioInputDTO;

import com.equoterapia.api.dto.usuario.UsuarioOutputDTO;
import com.equoterapia.api.dto.usuario.UsuarioUpdateInputDTO;
import com.equoterapia.api.mapeador.usuario.UsuarioMapeador;

import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.servico.usuario.UsuarioService;
import com.equoterapia.utilidades.Resposta;
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
    private UsuarioService usuarioService;

    @PostMapping("/salvar-novo-usuario")
    public ResponseEntity<Mensagem> salvarNovoUsuario(@RequestBody @Valid UsuarioInputDTO usuarioInputDTO) {
        usuarioService.save(UsuarioMapeador.converterUsuarioInputDTOEmUsuario(usuarioInputDTO));
        return new ResponseEntity<Mensagem>(new Mensagem(Resposta.USUARIO_CAD_OK), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar-usuario")
    public ResponseEntity<?> deletarUsuario(@RequestParam("id") Long id){
        usuarioService.deleteUserById(id);
        return new ResponseEntity<Mensagem>(new Mensagem("Usuário deletado com sucesso!"), HttpStatus.OK);
    }

    @PutMapping("/atualizar-usuario")
    public ResponseEntity<Mensagem> atualizarUsuario(@RequestBody @Valid UsuarioUpdateInputDTO usuarioUpdateInputDTO) {
        usuarioService.update(UsuarioMapeador.converterUsuarioUpdateInputDTOEmUsuario(usuarioUpdateInputDTO));
        return new ResponseEntity<Mensagem>(new Mensagem(Resposta.USUARIO_UP_OK), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-usuario-por-nome")
    public ResponseEntity<?> pesquisarUsuarioPorNome(@RequestParam("nome") @Valid @NotBlank String nome) {
        List<Usuario> listUsuario = usuarioService.pesquisarUsuarioPorNomeComOperadorLike(nome);
        return new ResponseEntity<List<UsuarioOutputDTO>>(UsuarioMapeador.converterListaUsuarioEmListaUsuarioOutputDTO(listUsuario), HttpStatus.OK);
    }

    @GetMapping("/buscar-usuario-por-id/{id}")
    public ResponseEntity<?> pesquisarUsuarioPorID(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findUsuario(id);
        return new ResponseEntity<UsuarioOutputDTO>(UsuarioMapeador.converterUsuarioEmUsuarioOutputDTO(usuario), HttpStatus.OK);
    }

}
