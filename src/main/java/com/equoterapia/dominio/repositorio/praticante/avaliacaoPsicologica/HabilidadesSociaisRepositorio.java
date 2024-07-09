package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.HabilidadesSociais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabilidadesSociaisRepositorio extends JpaRepository<HabilidadesSociais, Long> {
    @Query("select hs from HabilidadesSociais hs where hs.praticante.idPraticante = :idPraticante")
    public Optional<HabilidadesSociais> buscarHabilidadesSociaisPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
