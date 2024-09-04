package com.equoterapia.dominio.repositorio.praticante.paginacao;

import com.equoterapia.api.dto.praticante.fichaCadastroAdmissional.DadosPessoaisSaidaDTO;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PraticantePaginacaoRepositorio extends JpaRepository<DadosPessoais, Long> {

    @Override
    public Page<DadosPessoais> findAll(Pageable pageable);

    @Query("SELECT COUNT(p) FROM Praticante p")
    public int quantidadeTotalDePraticantes();

    @Query(value = "SELECT * FROM dados_pessoais ORDER BY id_dados_pessoais DESC LIMIT :maximo OFFSET :inicio",nativeQuery = true)
    public List<DadosPessoais> buscarPraticantesPorPagina(@Param("maximo") int maximo, @Param("inicio") int inicio);

}
