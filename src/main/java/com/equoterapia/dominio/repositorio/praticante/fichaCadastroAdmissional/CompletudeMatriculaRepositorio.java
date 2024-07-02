package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompletudeMatriculaRepositorio extends JpaRepository<CompletudeMatricula, Long> {
    @Query("select cm from CompletudeMatricula cm where cm.praticante.idPraticante = :idPraticante")
    public Optional<CompletudeMatricula> buscarCompletudeMatriculaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
