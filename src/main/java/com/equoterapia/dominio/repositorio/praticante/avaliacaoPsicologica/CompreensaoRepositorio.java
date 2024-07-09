package com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Compreensao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompreensaoRepositorio extends JpaRepository<Compreensao, Long> {
    @Query("select c from Compreensao c where c.praticante.idPraticante = :idPraticante")
    public Optional<Compreensao> buscarCompreensaoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
