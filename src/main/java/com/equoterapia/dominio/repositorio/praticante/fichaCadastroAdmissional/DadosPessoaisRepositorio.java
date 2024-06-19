package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DadosPessoaisRepositorio extends JpaRepository<DadosPessoais, Long> {

    public Optional<DadosPessoais> findByCpf(String cpf);
    public Optional<DadosPessoais> findByCartaoSUS(String cartaoSUS);

}
