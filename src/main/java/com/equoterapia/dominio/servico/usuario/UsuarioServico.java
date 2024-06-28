package com.equoterapia.dominio.servico.usuario;

import com.equoterapia.api.dto.novaSenha.NovaSenhaEntradaDTO;
import com.equoterapia.dominio.modelo.usuario.Usuario;

import java.util.Date;
import java.util.List;

public interface UsuarioServico {

    public Usuario salvar(Usuario usuario);
    public void atualizarUsuario(Usuario usuario);
    public void deletarUsuarioPorId(Long idUsuario);
    public Usuario buscarUsuarioPorId(Long idUsuario);
    public Usuario login(Usuario user);
    public Boolean verificarSeExisteUsuarioPorNomeDeUsuario(String username);
    public Usuario buscarUsuarioPorNomeDeUsuario(String username);
    public int atualizarTentativasErradasDeLogin(String username);
    public int buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(String username);
    public Date atualizarDataParaNovaTentativaDeLogin(String username);
    public Boolean verificarDataLiberarLogin(String username);
    public Date getDataLiberarLogin(String username);
    public void resetarTentativasELiberarLogin(String username);
    public Usuario atualizarSenha(NovaSenhaEntradaDTO newPasswordInputDTO);
    public List<Usuario> pesquisarUsuarioPorNomeComOperadorLike(String nomeUsuario);
}
