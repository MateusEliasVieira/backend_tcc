package com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.CoordenacaoMotora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordenacaoMotoraRepositorio extends JpaRepository<CoordenacaoMotora, Long> {
    @Query("select cm from CoordenacaoMotora cm where cm.praticante.idPraticante = :idPraticante")
    public Optional<CoordenacaoMotora> buscarCoordenacaoMotoraPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
