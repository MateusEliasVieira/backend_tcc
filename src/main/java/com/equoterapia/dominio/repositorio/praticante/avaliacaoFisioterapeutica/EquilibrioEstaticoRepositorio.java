package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioEstatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquilibrioEstaticoRepositorio extends JpaRepository<EquilibrioEstatico, Long> {
    @Query("select ee from EquilibrioEstatico ee where ee.praticante.idPraticante = :idPraticante")
    public Optional<EquilibrioEstatico> buscarEquilibrioEstaticoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
