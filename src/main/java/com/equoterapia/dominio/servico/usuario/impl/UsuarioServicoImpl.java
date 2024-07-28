package com.equoterapia.dominio.servico.usuario.impl;

import com.equoterapia.api.dto.novaSenha.NovaSenhaEntradaDTO;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.repositorio.usuario.UsuarioRepositorio;
import com.equoterapia.dominio.servico.usuario.UsuarioServico;
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
public class UsuarioServicoImpl implements UsuarioServico {

    @Autowired
    private UsuarioRepositorio repository;

    private final PasswordEncoder encriptadorDeSenha = new BCryptPasswordEncoder();

    private final int  MINUTOS_PARA_NOVA_TENTATIVA = 60;

    @Transactional(readOnly = false)
    @Override
    public Usuario salvar(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()).isEmpty()) {
            if (repository.buscarUsuarioPorNomeDeUsuario(usuario.getUsername()).isEmpty()) {
                if (repository.findByTelefone(usuario.getTelefone()).isEmpty()) {
                    if (repository.findByCpf(usuario.getCpf()).isEmpty()) {
                        // empty usuario
                        String tokenDoUsuario = JwtToken.generateTokenJWT(usuario);
                        usuario.setToken(tokenDoUsuario);
                        usuario.setStatus(false);
                        usuario.setRole(usuario.getRole());
                        usuario.setSenha(encriptadorDeSenha.encode(usuario.getPassword()));
                        Usuario usuarioSalvo = repository.save(usuario);
                        if (usuarioSalvo.getIdUsuario() == null) {
                            throw new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_SALVAR_USUARIO + usuario.getNome());
                        } else {
                            return usuarioSalvo;
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
    public void atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioPorNomeUsuario = repository.buscarUsuarioPorNomeDeUsuario(usuario.getNomeUsuario());
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
        repository.atualizarUsuarioPorId(
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
    public void deletarUsuarioPorId(Long idUsuario) {
        repository.findById(idUsuario).ifPresentOrElse((usuario) -> {
            repository.deleteById(idUsuario);
        }, () -> {
            throw new ExcecaoDeRegrasDeNegocio("Houve uma falha ao localizar esse usuário no sistema!");
        });
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarUsuarioPorId(Long idUsuario) {
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
    public Usuario login(Usuario usuario) {
        usuario.setToken(JwtToken.generateTokenJWT(usuario));
        usuario.setTentativasLogin(0);
        usuario.setLiberarLogin(null); // coloca a data atual para liberar o login (colocado apenas para não deixar nulo) Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-03:00")))
        usuario.setStatus(true);
        return repository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean verificarSeExisteUsuarioPorNomeDeUsuario(String nomeDeUsuario) {
        Optional<Usuario> userOptional = repository.buscarUsuarioPorNomeDeUsuario(nomeDeUsuario);
        return userOptional.isPresent();
    }

    @Transactional(readOnly = false)
    @Override
    public int atualizarTentativasErradasDeLogin(String nomeDeUsuario) {
        int tentativas = repository.buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(nomeDeUsuario) + 1;
        repository.atualizarTentativasErradasDeLoginDoUsuario(tentativas, nomeDeUsuario);
        return repository.buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(nomeDeUsuario);
    }

    @Transactional(readOnly = true)
    @Override
    public int buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(String nomeDeUsuario) {
        return repository.buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(nomeDeUsuario);
    }

    @Transactional(readOnly = false)
    @Override
    public Date atualizarDataParaNovaTentativaDeLogin(String nomeDeUsuario) {
        // get current date and time
        LocalDateTime agora = LocalDateTime.now();
        // Add minutes
        LocalDateTime minutos = agora.plusMinutes(MINUTOS_PARA_NOVA_TENTATIVA);
        // release date
        Date dataParaLiberarLogin = Date.from(minutos.toInstant(ZoneOffset.of("-03:00")));
        repository.atualizarDataParaNovaTentativaDeLogin(dataParaLiberarLogin, nomeDeUsuario);
        return dataParaLiberarLogin;
    }

    @Transactional(readOnly = true)
    @Override
    public Date getDataLiberarLogin(String nomeDeUsuario) {
        return repository.getDataLiberarLogin(nomeDeUsuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean verificarDataLiberarLogin(String nomeDeUsuario) {
        System.out.println("Data = "+repository.getDataLiberarLogin(nomeDeUsuario));
        return repository.getDataLiberarLogin(nomeDeUsuario) != null;
    }

    @Transactional(readOnly = false)
    @Override
    public void resetarTentativasELiberarLogin(String nomeDeUsuario) {
        repository.resetarTentativasELiberarLogin(nomeDeUsuario);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario atualizarSenha(NovaSenhaEntradaDTO newPasswordInputDTO) {
        Usuario usuario = repository.pesquisarUsuarioPorToken(newPasswordInputDTO.getToken()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.ERRO_MUDANCA_SENHA));
        usuario.setSenha(encriptadorDeSenha.encode(newPasswordInputDTO.getNovaSenha()));
        return repository.save(usuario);
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario buscarUsuarioPorNomeDeUsuario(String nomeDeUsuario) {
        return repository.buscarUsuarioPorNomeDeUsuario(nomeDeUsuario).get();
    }
}


