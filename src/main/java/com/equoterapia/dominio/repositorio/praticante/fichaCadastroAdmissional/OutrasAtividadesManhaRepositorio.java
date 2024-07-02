package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesManha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutrasAtividadesManhaRepositorio extends JpaRepository<OutrasAtividadesManha, Long> {
    @Query("select oam from OutrasAtividadesManha oam where oam.praticante.idPraticante = :idPraticante")
    public Optional<OutrasAtividadesManha> buscarOutrasAtividadesManhaPorChaveEstrangeira(@Param("idPraticante") Long idPraticante);
}
