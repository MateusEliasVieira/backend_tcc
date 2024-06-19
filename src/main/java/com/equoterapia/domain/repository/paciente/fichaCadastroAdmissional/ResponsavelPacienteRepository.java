package com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.ResponsavelPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsavelPacienteRepository extends JpaRepository<ResponsavelPaciente,Long> {
    public Optional<ResponsavelPaciente> findByEmail(String email);
}
