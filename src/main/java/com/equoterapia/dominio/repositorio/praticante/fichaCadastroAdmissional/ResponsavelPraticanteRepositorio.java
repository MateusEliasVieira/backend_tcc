package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsavelPraticanteRepositorio extends JpaRepository<ResponsavelPraticante,Long> {
    public Optional<ResponsavelPraticante> findByEmail(String email);
    public Optional<ResponsavelPraticante> findByTelefone(String telefone);
    public Optional<ResponsavelPraticante> findByTelefoneTrabalho(String telefone);
    @Query("select rp from ResponsavelPraticante rp where rp.praticante.idPraticante = :idPraticante")
    public Optional<ResponsavelPraticante> buscarResponsavelPraticantePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);

}
