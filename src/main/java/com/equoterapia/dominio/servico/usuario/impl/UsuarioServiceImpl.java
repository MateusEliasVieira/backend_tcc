package com.equoterapia.dominio.servico.usuario.impl;

import com.equoterapia.api.dto.novaSenha.NovaSenhaEntradaDTO;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.repositorio.usuario.UsuarioRepositorio;
import com.equoterapia.dominio.servico.usuario.UsuarioService;
import com.equoterapia.seguranca.jwt.JwtToken;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio repository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final int MINUTES_TO_RETRY = 1;

    @Transactional(readOnly = false)
    @Override
    public Usuario save(Usuario user) {
        if (repository.findUserByEmail(user.getEmail()) == null && repository.findUserByUsername(user.getUsername()) == null) {
            // empty user
            String firstTokenUser = JwtToken.generateTokenJWT(user);
            user.setToken(firstTokenUser);
            user.setStatus(false);
            user.setRole(user.getRole());
            user.setSenha(passwordEncoder.encode(user.getPassword()));
            Usuario userSaved = repository.save(user);
            if (userSaved.getIdUsuario() == null) {
                throw new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_SALVAR_USUARIO + user.getNome());
            } else {
                return userSaved;
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio(Resposta.USUARIO_EXISTE);
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Usuario usuario) {
        repository.updateUserById(usuario.getIdUsuario(), usuario.getNome(), usuario.getFoto(),
                usuario.getDataNascimento(), usuario.getCpf(),
                usuario.getEstadoCivil(), usuario.getTelefone(),
                usuario.getEmail(), usuario.getDetalhesFormacao(),
                usuario.getCidade(), usuario.getBairro(),
                usuario.getLogradouro(), usuario.getRole(),
                usuario.getVinculo(), usuario.getPossuiFormacao());
    }

    @Override
    public void deleteUserById(Long idUsuario) {
        repository.findById(idUsuario).ifPresentOrElse((usuario) -> {
            repository.deleteById(idUsuario);
        }, () -> {
            throw new ExcecaoDeRegrasDeNegocio("Houve uma falha ao localizar esse usuário no sistema!");
        });
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findUsuario(Long idUsuario) {
        Optional<Usuario> UsuarioOptional = repository.findById(idUsuario);
        return UsuarioOptional.orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.USUARIO_ID_INEXISTENTE + idUsuario));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> pesquisarUsuarioPorNomeComOperadorLike(String nomeUsuario) {
        return repository.pesquisarUsuarioPorNomeComOperadorLike(nomeUsuario);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario saveUserAfterConfirmedAccountByEmail(String token) {
        Usuario user = repository.findUserByToken(token).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_CONFIRMACAO_CONTA));
        // token exist from email confirmation
        user.setStatus(true);
        return repository.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario login(Usuario user) {
        user.setToken(JwtToken.generateTokenJWT(user));
        user.setTentativasLogin(0);
        user.setLiberarLogin(null);
        user.setStatus(true);
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findUser(Long idUser) {
        Optional<Usuario> userOptional = repository.findById(idUser);
        return userOptional.orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.USUARIO_ID_INEXISTENTE + idUser));
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean findUser(String username) {
        Optional<Usuario> userOptional = Optional.ofNullable(repository.findUserByUsername(username));
        return userOptional.isPresent();
    }

    @Transactional(readOnly = false)
    @Override
    public int updateAttempts(String username) {
        int attempts = repository.attemptsUser(username) + 1;
        repository.updateAttemptsUser(attempts, username);
        return repository.attemptsUser(username);
    }

    @Transactional(readOnly = true)
    @Override
    public int attemptsUser(String username) {
        return repository.attemptsUser(username);
    }

    @Transactional(readOnly = false)
    @Override
    public Date releaseLogin(String username) {
        // get current date and time
        LocalDateTime now = LocalDateTime.now();
        // Add minutes
        LocalDateTime minutes = now.plusMinutes(MINUTES_TO_RETRY);
        // release date
        Date releaseDate = Date.from(minutes.toInstant(ZoneOffset.of("-03:00")));
        repository.updateReleaseDate(releaseDate, username);
        return releaseDate;
    }

    @Transactional(readOnly = true)
    @Override
    public Date getDateReleaseLogin(String username) {
        return repository.getDateReleaseLogin(username);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean verifyReleaseDateLogin(String username) {
        return repository.getDateReleaseLogin(username) != null;
    }

    @Transactional(readOnly = false)
    @Override
    public void resetAttemptsAndReleaseLogin(String username) {
        repository.resetAttemptsAndReleaseLogin(username);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario updatePassword(NovaSenhaEntradaDTO newPasswordInputDTO) {
        Usuario user = repository.findUserByToken(newPasswordInputDTO.getToken()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_MUDANCA_SENHA));
        user.setSenha(passwordEncoder.encode(newPasswordInputDTO.getNovaSenha()));
        return repository.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }
}


