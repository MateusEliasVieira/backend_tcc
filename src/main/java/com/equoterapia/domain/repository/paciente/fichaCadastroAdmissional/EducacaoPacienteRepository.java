package com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.EducacaoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacaoPacienteRepository extends JpaRepository<EducacaoPaciente, Long> {
}
