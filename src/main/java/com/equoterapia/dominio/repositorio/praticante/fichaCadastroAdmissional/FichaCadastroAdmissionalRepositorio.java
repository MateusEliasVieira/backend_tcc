package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FichaCadastroAdmissionalRepositorio extends JpaRepository<FichaCadastroAdmissional, Long> {
    @Query("select fca from FichaCadastroAdmissional fca where fca.praticante.idPraticante = :idPraticante")
    public Optional<FichaCadastroAdmissional> buscarFichaCadastroAdmissionalPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
