package com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.CompletudeMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletudeMatriculaRepository extends JpaRepository<CompletudeMatricula, Long> {

}
