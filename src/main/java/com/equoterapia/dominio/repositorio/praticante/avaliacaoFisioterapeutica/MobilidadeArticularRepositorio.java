package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.MobilidadeArticular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MobilidadeArticularRepositorio extends JpaRepository<MobilidadeArticular, Long> {
    @Query("select ma from MobilidadeArticular ma where ma.praticante.idPraticante = :idPraticante")
    public Optional<MobilidadeArticular> buscarMobilidadeArticularPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
