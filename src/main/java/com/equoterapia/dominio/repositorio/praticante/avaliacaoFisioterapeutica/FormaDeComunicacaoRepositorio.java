package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.FormaDeComunicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormaDeComunicacaoRepositorio extends JpaRepository<FormaDeComunicacao, Long> {
    @Query("select fc from FormaDeComunicacao fc where fc.praticante.idPraticante = :idPraticante")
    public Optional<FormaDeComunicacao> buscarFormaDeComunicacaoPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
