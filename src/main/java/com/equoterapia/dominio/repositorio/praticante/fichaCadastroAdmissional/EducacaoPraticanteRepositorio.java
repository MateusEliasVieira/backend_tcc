package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducacaoPraticanteRepositorio extends JpaRepository<EducacaoPraticante, Long> {
    @Query("select ep from EducacaoPraticante ep where ep.praticante.idPraticante = :idPraticante")
    public Optional<EducacaoPraticante> buscarEducacaoPraticantePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
