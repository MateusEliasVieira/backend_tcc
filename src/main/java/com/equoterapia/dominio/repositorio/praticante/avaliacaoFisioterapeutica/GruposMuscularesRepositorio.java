package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.GruposMusculares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GruposMuscularesRepositorio extends JpaRepository<GruposMusculares, Long> {
    @Query("select gm from GruposMusculares gm where gm.praticante.idPraticante = :idPraticante")
    public Optional<GruposMusculares> buscarGruposMuscularesPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
