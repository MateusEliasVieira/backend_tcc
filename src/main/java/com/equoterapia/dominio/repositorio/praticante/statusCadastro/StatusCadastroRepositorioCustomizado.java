package com.equoterapia.dominio.repositorio.praticante.statusCadastro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StatusCadastroRepositorioCustomizado implements StatusCadastro {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int verificarQuantidadeTotalDeCadastrosNaoFinalizadosDoPraticante(Long idPraticante) {
        String sql = "SELECT SUM(registros_nao_finalizados) AS total_registros_nao_finalizados FROM (\n" +
                "    SELECT COUNT(*) AS registros_nao_finalizados\n" +
                "    FROM afetividade \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM avaliacao_fisioterapeutica \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM avaliacao_psicologica \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM completude_matricula \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM comportamento \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM compreensao \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM coordenacao_motora \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM cuidados_pessoais \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM dados_pessoais \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM educacao_praticante \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM em_pe \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM emergencia \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM equilibrio_dinamico \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM equilibrio_estatico \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM ficha_cadastro_admissional \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM forma_de_comunicacao \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM grupos_musculares \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM habilidades_motorasavd \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM habilidades_sociais \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM linguagem \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM mobilidade_articular \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM outras_atividades_manha \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM outras_atividades_tarde \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM plano_terapeutico_singular \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM quadro_atual \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM relacao_familiar_examinado \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM responsavel_praticante \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM rotina \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM saude \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM saude_geral_do_praticante \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM saude_mental \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM sobreacrianca \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM socializacao \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                "\n" +
                "    UNION ALL\n" +
                "\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM tracos_de_personalidade \n" +
                "    WHERE finalizado != TRUE AND praticante_id_praticante = :idPraticante\n" +
                ") AS subquery";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("idPraticante", idPraticante);

        Number result = (Number) query.getSingleResult();
        return result.intValue();
    }


}
