package com.equoterapia.api.controller.usuario;

import com.equoterapia.api.controller.utils.Mensagem;
import com.equoterapia.api.dto.usuario.UsuarioInputDTO;

import com.equoterapia.api.dto.usuario.UsuarioOutputDTO;
import com.equoterapia.api.dto.usuario.UsuarioUpdateInputDTO;
import com.equoterapia.api.mapper.usuario.UsuarioMapper;

import com.equoterapia.domain.model.usuario.Usuario;
import com.equoterapia.domain.service.usuario.UsuarioService;
import com.equoterapia.utils.Feedback;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar-novo-usuario")
    public ResponseEntity<Mensagem> salvarNovoUsuario(@RequestBody @Valid UsuarioInputDTO usuarioInputDTO) {
        usuarioService.save(UsuarioMapper.converterUsuarioInputDTOEmUsuario(usuarioInputDTO));
        return new ResponseEntity<Mensagem>(new Mensagem(Feedback.USUARIO_CAD_OK), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar-usuario")
    public ResponseEntity<?> deletarUsuario(@RequestParam("id") Long id){
        usuarioService.deleteUserById(id);
        return new ResponseEntity<Mensagem>(new Mensagem("Usuário deletado com sucesso!"), HttpStatus.OK);
    }

    @PutMapping("/atualizar-usuario")
    public ResponseEntity<Mensagem> atualizarUsuario(@RequestBody @Valid UsuarioUpdateInputDTO usuarioUpdateInputDTO) {
        usuarioService.update(UsuarioMapper.converterUsuarioUpdateInputDTOEmUsuario(usuarioUpdateInputDTO));
        return new ResponseEntity<Mensagem>(new Mensagem(Feedback.USUARIO_UP_OK), HttpStatus.CREATED);
    }

    @GetMapping("/buscar-usuario-por-nome")
    public ResponseEntity<?> pesquisarUsuarioPorNome(@RequestParam("nome") @Valid @NotBlank String nome) {
        List<Usuario> listUsuario = usuarioService.pesquisarUsuarioPorNomeComOperadorLike(nome);
        return new ResponseEntity<List<UsuarioOutputDTO>>(UsuarioMapper.converterListaUsuarioEmListaUsuarioOutputDTO(listUsuario), HttpStatus.OK);
    }

    @GetMapping("/buscar-usuario-por-id")
    public ResponseEntity<?> pesquisarUsuarioPorNome(@RequestParam("id") @Valid @NotNull Long id) {
        Usuario usuario = usuarioService.findUsuario(id);
        return new ResponseEntity<UsuarioOutputDTO>(UsuarioMapper.converterUsuarioEmUsuarioOutputDTO(usuario), HttpStatus.OK);
    }

}
