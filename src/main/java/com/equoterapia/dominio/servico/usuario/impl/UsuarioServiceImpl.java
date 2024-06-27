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
    public Usuario save(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()).isEmpty()) {
            if (repository.findUserByUsername(usuario.getUsername()).isEmpty()) {
                if (repository.findByTelefone(usuario.getTelefone()).isEmpty()) {
                    if (repository.findByCpf(usuario.getCpf()).isEmpty()) {
                        // empty usuario
                        String firstTokenUser = JwtToken.generateTokenJWT(usuario);
                        usuario.setToken(firstTokenUser);
                        usuario.setStatus(false);
                        usuario.setRole(usuario.getRole());
                        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
                        Usuario userSaved = repository.save(usuario);
                        if (userSaved.getIdUsuario() == null) {
                            throw new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_SALVAR_USUARIO + usuario.getNome());
                        } else {
                            return userSaved;
                        }
                    } else {
                        throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o cpf " + usuario.getCpf());
                    }
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o telefone " + usuario.getTelefone());
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o nome de usuário " + usuario.getUsername());
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o email " + usuario.getEmail());
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Usuario usuario) {
        Optional<Usuario> usuarioPorNomeUsuario = repository.findUserByUsername(usuario.getNomeUsuario());
        Optional<Usuario> usuarioPorCpf = repository.findByCpf(usuario.getCpf());
        Optional<Usuario> usuarioPorEmail = repository.findByEmail(usuario.getEmail());
        Optional<Usuario> usuarioPorTelefone = repository.findByTelefone(usuario.getTelefone());

        if (usuarioPorNomeUsuario.isPresent() && !usuarioPorNomeUsuario.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o nome de usuário " + usuarioPorNomeUsuario.get().getUsername());
        }

        if (usuarioPorCpf.isPresent() && !usuarioPorCpf.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o CPF " + usuarioPorCpf.get().getCpf());
        }

        if (usuarioPorEmail.isPresent() && !usuarioPorEmail.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o E-mail " + usuarioPorEmail.get().getEmail());
        }

        if (usuarioPorTelefone.isPresent() && !usuarioPorTelefone.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um usuário cadastrado com o telefone " + usuarioPorTelefone.get().getTelefone());
        }

        // Pode salvar, pois não tem risco de ter atualizado algum email, CPF, nome de usuário ou telefone que seja de outro usuário cadastrado
        repository.updateUserById(
                usuario.getIdUsuario(), usuario.getNome(), usuario.getFoto(),
                usuario.getDataNascimento(), usuario.getCpf(),
                usuario.getEstadoCivil(), usuario.getTelefone(),
                usuario.getEmail(), usuario.getDetalhesFormacao(),
                usuario.getCidade(), usuario.getBairro(),
                usuario.getLogradouro(), usuario.getRole(),
                usuario.getVinculo(), usuario.getPossuiFormacao()
        );
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
        Usuario usuario = repository.findUserByToken(token).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_CONFIRMACAO_CONTA));
        // token exist from email confirmation
        usuario.setStatus(true);
        return repository.save(usuario);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario login(Usuario usuario) {
        usuario.setToken(JwtToken.generateTokenJWT(usuario));
        usuario.setTentativasLogin(0);
        usuario.setLiberarLogin(null);
        usuario.setStatus(true);
        return repository.save(usuario);
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
        Optional<Usuario> userOptional = repository.findUserByUsername(username);
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
        Usuario usuario = repository.findUserByToken(newPasswordInputDTO.getToken()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_MUDANCA_SENHA));
        usuario.setSenha(passwordEncoder.encode(newPasswordInputDTO.getNovaSenha()));
        return repository.save(usuario);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario findUserByUsername(String username) {
        return repository.findUserByUsername(username).get();
    }
}


