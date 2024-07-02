package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmergenciaRepositorio extends JpaRepository<Emergencia, Long> {

    public Optional<Emergencia> findByTelefone(String telefone);
    @Query("select e from Emergencia e where e.praticante.idPraticante = :idPraticante")
    public Optional<Emergencia> buscarEmergenciaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
