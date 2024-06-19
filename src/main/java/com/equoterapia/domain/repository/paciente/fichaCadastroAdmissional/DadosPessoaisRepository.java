package com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Long> {

    public Optional<DadosPessoais> findByCpf(String cpf);
    public Optional<DadosPessoais> findByCartaoSUS(String cartaoSUS);

}
