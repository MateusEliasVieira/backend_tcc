package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DadosPessoaisRepositorio extends JpaRepository<DadosPessoais, Long> {

    public Optional<DadosPessoais> findByCpf(String cpf);
    public Optional<DadosPessoais> findByCartaoSUS(String cartaoSUS);

    @Query("SELECT dp FROM DadosPessoais dp WHERE dp.nomeCompleto LIKE %:nome%")
    public List<DadosPessoais> findByNomeCompleto(@Param("nome") String nome);

}
