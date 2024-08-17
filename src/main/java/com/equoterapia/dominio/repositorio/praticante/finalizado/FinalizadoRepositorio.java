package com.equoterapia.dominio.repositorio.praticante.finalizado;

import com.equoterapia.dominio.modelo.praticante.Finalizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FinalizadoRepositorio extends JpaRepository<Finalizado, Long> {


    @Query("SELECT f FROM Finalizado f WHERE f.praticante.idPraticante = :idPraticante")
    public Optional<Finalizado> consultarStatusDeCadastroDoPraticante(@Param("idPraticante") Long idPraticante);

}
