package com.equoterapia.domain.repository.usuario;

import com.equoterapia.domain.enums.EstadoCivil;
import com.equoterapia.domain.enums.Role;
import com.equoterapia.domain.enums.Vinculo;
import com.equoterapia.domain.model.usuario.Usuario;
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
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

        @Modifying
        @Query("UPDATE Usuario u SET u.nome = :nome, u.foto = :foto, u.dataNascimento = :dataNascimento, u.cpf = :cpf, " +
                "u.estadoCivil = :estadoCivil, u.telefone = :telefone, u.email = :email, u.detalhesFormacao = :detalhesFormacao, " +
                "u.cidade = :cidade, u.bairro = :bairro, u.logradouro = :logradouro, u.role = :role, u.vinculo = :vinculo, " +
                "u.possuiFormacao = :possuiFormacao WHERE u.idUsuario = :idUsuario")
        public void updateUserById(@Param("idUsuario") Long idUsuario, @Param("nome") String nome, @Param("foto") String foto,
                                   @Param("dataNascimento") Date dataNascimento, @Param("cpf") String cpf,
                                   @Param("estadoCivil") EstadoCivil estadoCivil, @Param("telefone") String telefone,
                                   @Param("email") String email, @Param("detalhesFormacao") String detalhesFormacao,
                                   @Param("cidade") String cidade, @Param("bairro") String bairro,
                                   @Param("logradouro") String logradouro, @Param("role") Role role,
                                   @Param("vinculo") Vinculo vinculo, @Param("possuiFormacao") Boolean possuiFormacao);
        @Query("SELECT u FROM Usuario u WHERE u.nomeUsuario LIKE %:nomeUsuario%")
        public List<Usuario> pesquisarUsuarioPorNomeComOperadorLike(@Param("nomeUsuario") String nomeUsuario);

        @Modifying
        @Query("UPDATE Usuario u SET u.status = true WHERE u.token = :token")
        public Integer updateStatusUserByToken(@Param("token") String token);

        @Query("SELECT u FROM Usuario u WHERE u.email = :email")
        public Usuario findUserByEmail(@Param("email") String email);

        public UserDetails findByNomeUsuario(String nomeUsuario);

        @Query("SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
        public Usuario findUserByUsername(@Param("nomeUsuario") String nomeUsuario);

        @Query("SELECT u FROM Usuario u WHERE u.token = :token")
        public Optional<Usuario> findUserByToken(@Param("token") String token);

        @Modifying
        @Query("UPDATE Usuario u SET u.tentativasLogin = :tentativasLogin WHERE u.nomeUsuario = :nomeUsuario")
        public void updateAttemptsUser(@Param("tentativasLogin") int tentativasLogin, @Param("nomeUsuario") String nomeUsuario);

        @Query("SELECT u.tentativasLogin FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
        public int attemptsUser(@Param("nomeUsuario") String nomeUsuario);

        @Query("SELECT u.role FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
        public Role findRoleByUsername(@Param("nomeUsuario") String nomeUsuario);

        @Modifying
        @Query("UPDATE Usuario u SET u.liberarLogin = :liberarLogin WHERE u.nomeUsuario = :nomeUsuario")
        public void updateReleaseDate(@Param("liberarLogin") Date liberarLogin, @Param("nomeUsuario") String nomeUsuario);

        @Query("SELECT u.liberarLogin FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario")
        public Date getDateReleaseLogin(@Param("nomeUsuario") String nomeUsuario);

        @Modifying
        @Query("UPDATE Usuario u SET u.liberarLogin = null, u.tentativasLogin = 0 WHERE u.nomeUsuario = :nomeUsuario")
        public void resetAttemptsAndReleaseLogin(@Param("nomeUsuario") String nomeUsuario);

        @Modifying
        @Query("UPDATE Usuario u SET u.status = true WHERE u.token = :token")
        public Integer updateStatusUsuarioByToken(@Param("token") String token);

    }





