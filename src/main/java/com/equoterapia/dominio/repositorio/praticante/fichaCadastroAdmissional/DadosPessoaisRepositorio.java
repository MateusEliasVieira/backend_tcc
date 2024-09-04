package com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DadosPessoaisRepositorio extends JpaRepository<DadosPessoais, Long> {

    public Optional<DadosPessoais> findByCpf(String cpf);
    public Optional<DadosPessoais> findByCartaoSUS(String cartaoSUS);

    @Query(value = "SELECT * FROM dados_pessoais ORDER BY id_dados_pessoais DESC LIMIT 5 OFFSET 0",nativeQuery = true)
    public Optional<List<DadosPessoais>> buscarPrimeiraPagina();

    @Query(value = "SELECT * FROM dados_pessoais WHERE nome_completo LIKE CONCAT('%', :nome, '%') ORDER BY id_dados_pessoais DESC LIMIT 5", nativeQuery = true)
    public List<DadosPessoais> findByNomeCompleto(@Param("nome") String nome);

    @Query("SELECT dp FROM DadosPessoais dp WHERE dp.praticante.idPraticante = :idPraticante")
    public Optional<DadosPessoais> buscarDadosPessoaisPorIdDoPraticante(@Param("idPraticante") Long idPraticante);


}
