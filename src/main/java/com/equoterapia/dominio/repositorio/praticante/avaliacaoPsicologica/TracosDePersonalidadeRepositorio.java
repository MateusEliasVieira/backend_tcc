package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.TracosDePersonalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TracosDePersonalidadeRepositorio extends JpaRepository<TracosDePersonalidade, Long> {
    @Query("select tp from TracosDePersonalidade tp where tp.praticante.idPraticante = :idPraticante")
    public Optional<TracosDePersonalidade> buscarTracosDePersonalidadePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
