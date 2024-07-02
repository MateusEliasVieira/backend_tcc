package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesTarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutrasAtividadesTardeRepositorio extends JpaRepository<OutrasAtividadesTarde, Long> {
    @Query("select oat from OutrasAtividadesTarde oat where oat.praticante.idPraticante = :idPraticante")
    public Optional<OutrasAtividadesTarde> buscarOutrasAtividadesTardePorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
