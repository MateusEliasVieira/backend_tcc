package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.CuidadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuidadosPessoaisRepositorio extends JpaRepository<CuidadosPessoais, Long> {
    @Query("select cp from CuidadosPessoais cp where cp.praticante.idPraticante = :idPraticante")
    public Optional<CuidadosPessoais> buscarCuidadosPessoaisPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
