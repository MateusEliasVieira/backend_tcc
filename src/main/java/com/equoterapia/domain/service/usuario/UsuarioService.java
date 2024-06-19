package com.equoterapia.domain.service.usuario;

import com.equoterapia.api.dto.novaSenha.NovaSenhaInputDTO;
import com.equoterapia.domain.model.usuario.Usuario;

import java.util.Date;
import java.util.List;

public interface UsuarioService {

    public Usuario save(Usuario usuario);
    public void update(Usuario usuario);
    public void deleteUserById(Long idUsuario);
    public Usuario findUsuario(Long idUsuario);
    public Usuario saveUserAfterConfirmedAccountByEmail(String token);
    public Usuario login(Usuario user);
    //public Usuario loginWithGoogle(Usuario user);
    public Usuario findUser(Long idUser);
    public Boolean findUser(String username);
    public Usuario findUserByUsername(String username);
    public int updateAttempts(String username);
    public int attemptsUser(String username);
    public Date releaseLogin(String username);
    public Boolean verifyReleaseDateLogin(String username);
    public Date getDateReleaseLogin(String username);
    public void resetAttemptsAndReleaseLogin(String username);
    public Usuario updatePassword(NovaSenhaInputDTO newPasswordInputDTO);
    public List<Usuario> pesquisarUsuarioPorNomeComOperadorLike(String nomeUsuario);
}
