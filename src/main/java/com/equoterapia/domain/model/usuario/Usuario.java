package com.equoterapia.domain.model.usuario;

import com.equoterapia.domain.enums.EstadoCivil;
import com.equoterapia.domain.enums.Role;
import com.equoterapia.domain.enums.Vinculo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nome;
    @Lob // usada em JPA para indicar que um atributo de uma entidade deve ser mapeado para um tipo de objeto grande no banco de dados
    @Column(columnDefinition = "LONGTEXT")
    private String foto;
    private Date dataNascimento;
    @Column(unique = true)
    private String cpf;
    private EstadoCivil estadoCivil;
    @Column(unique = true)
    private String telefone;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nomeUsuario;
    private String senha;
    private String detalhesFormacao;
    private String cidade;
    private String bairro;
    private String logradouro;
    private Role role;
    private Vinculo vinculo;
    private Boolean possuiFormacao;
    private String token;
    private boolean status;
    private int tentativasLogin;
    private Date liberarLogin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ROLE_ADMIN) {
            // se esse usuário tiver uma role de admin, retornamos os tipos de acesso que ele pode ter no sistema, nesse caso admin e user
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }

        if (this.role == Role.ROLE_USER) {
            // se esse usuário tiver uma role de user, retornamos o tipo de acesso que ele pode ter no sistema, nesse caso apenas user
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return null;
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

