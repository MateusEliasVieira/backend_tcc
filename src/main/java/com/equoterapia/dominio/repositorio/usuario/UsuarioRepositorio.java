package com.equoterapia.dominio.repositorio.usuario;

import com.equoterapia.dominio.enums.EstadoCivilEnum;
import com.equoterapia.dominio.enums.RoleEnum;
import com.equoterapia.dominio.enums.VinculoEnum;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Modifying
    @Query("UPDATE Usuario u SET u.nome = :nome, u.foto = :foto, u.dataNascimento = :dataNascimento, u.cpf = :cpf, " +
            "u.estadoCivil = :estadoCivil, u.telefone = :telefone, u.email = :email, u.detalhesFormacao = :detalhesFormacao, " +
            "u.cidade = :cidade, u.bairro = :bairro, u.logradouro = :logradouro, u.role = :role, u.vinculo = :vinculo, " +
            "u.possuiFormacao = :possuiFormacao WHERE u.idUsuario = :idUsuario")
    public void atualizarUsuarioPorId(@Param("idUsuario") Long idUsuario, @Param("nome") String nome, @Param("foto") String foto,
                                      @Param("dataNascimento") Date dataNascimento, @Param("cpf") String cpf,
                                      @Param("estadoCivil") EstadoCivilEnum estadoCivil, @Param("telefone") String telefone,
                                      @Param("email") String email, @Param("detalhesFormacao") String detalhesFormacao,
                                      @Param("cidade") String cidade, @Param("bairro") String bairro,
                                      @Param("logradouro") String logradouro, @Param("role") RoleEnum role,
                                      @Param("vinculo") VinculoEnum vinculo, @Param("possuiFormacao") Boolean possuiFormacao);

    @Query("SELECT u FROM Usuario u WHERE u.nomeUsuario LIKE %:nomeUsuario%")
    public List<Usuario> pesquisarUsuarioPorNomeComOperadorLike(@Param("nomeUsuario") String nomeUsuario);

    public UserDetails findByNomeUsuario(String nomeUsuario);

    @Query("SELECT u FROM Usuario u WHERE u.token = :token")
    public Optional<Usuario> pesquisarUsuarioPorToken(@Param("token") String token);

    @Modifying
    @Query("UPDATE Usuario u SET u.tentativasLogin = :tentativasLogin WHERE u.nomeUsuario = :nomeUsuario")
    public void atualizarTentativasErradasDeLoginDoUsuario(@Param("tentativasLogin") int tentativasLogin, @Param("nomeUsuario") String nomeUsuario);

    @Query("SELECT u.tentativasLogin FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
    public int buscarTentativasDeLoginDoUsuarioPorNomeDeUsuario(@Param("nomeUsuario") String nomeUsuario);

    @Modifying
    @Query("UPDATE Usuario u SET u.liberarLogin = :liberarLogin WHERE u.nomeUsuario = :nomeUsuario")
    public void atualizarDataParaNovaTentativaDeLogin(@Param("liberarLogin") Date liberarLogin, @Param("nomeUsuario") String nomeUsuario);

    @Query("SELECT u.liberarLogin FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
    public Date getDataLiberarLogin(@Param("nomeUsuario") String nomeUsuario);

    @Modifying
    @Query("UPDATE Usuario u SET u.liberarLogin = null, u.tentativasLogin = 0 WHERE u.nomeUsuario = :nomeUsuario")
    public void resetarTentativasELiberarLogin(@Param("nomeUsuario") String nomeUsuario);

    @Query("SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
    public Optional<Usuario> buscarUsuarioPorNomeDeUsuario(@Param("nomeUsuario") String nomeUsuario);

    public Optional<Usuario> findByTelefone(String telefone);

    public Optional<Usuario> findByCpf(String cpf);

    public Optional<Usuario> findByEmail(String email);

}





