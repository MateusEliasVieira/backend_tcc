package com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Long> {

    public Optional<Emergencia> findByTelefone(String telefone);
}
