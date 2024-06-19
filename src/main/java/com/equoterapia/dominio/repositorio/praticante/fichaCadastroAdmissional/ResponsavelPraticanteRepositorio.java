package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsavelPraticanteRepositorio extends JpaRepository<ResponsavelPraticante,Long> {
    public Optional<ResponsavelPraticante> findByEmail(String email);
}
