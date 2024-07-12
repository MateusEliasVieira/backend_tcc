package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabilidadesMotorasAVDRepositorio extends JpaRepository<HabilidadesMotorasAVD, Long> {
    @Query("select hmavd from HabilidadesMotorasAVD hmavd where hmavd.praticante.idPraticante = :idPraticante")
    public Optional<HabilidadesMotorasAVD> buscarHabilidadesMotorasAVDPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
