package com.equoterapia.dominio.repositorio.praticante.statusCadastro;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusCadastroRepositorio extends JpaRepository<Praticante, Long> {

    @Query(value = "SELECT SUM(total_registros_nao_finalizados) AS total_registros_nao_finalizados\n" +
            "FROM (\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM afetividade \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM avaliacao_fisioterapeutica \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM avaliacao_psicologica \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM completude_matricula \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM comportamento \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM compreensao \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM coordenacao_motora \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM cuidados_pessoais \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM dados_pessoais \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM educacao_praticante \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM em_pe \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM emergencia \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM equilibrio_dinamico \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM equilibrio_estatico \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM forma_de_comunicacao \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM grupos_musculares \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM habilidades_motorasavd \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM habilidades_sociais \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM linguagem \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM mobilidade_articular \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM outras_atividades_manha \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM outras_atividades_tarde \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM plano_terapeutico_singular \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM quadro_atual \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM relacao_familiar_examinado \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM responsavel_praticante \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM rotina \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM saude \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM saude_geral_do_praticante \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM saude_mental \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM sobreacrianca \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM socializacao \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            "\n" +
            "    UNION ALL\n" +
            "\n" +
            "    SELECT CASE \n" +
            "               WHEN COUNT(*) = 0 THEN 1 \n" +
            "               ELSE\n" +
            "                   CASE \n" +
            "                       WHEN SUM(CASE WHEN finalizado = FALSE OR finalizado IS NULL THEN 1 ELSE 0 END) > 0 \n" +
            "                       THEN 1 \n" +
            "                       ELSE 0 \n" +
            "                   END\n" +
            "           END AS total_registros_nao_finalizados\n" +
            "    FROM tracos_de_personalidade \n" +
            "    WHERE praticante_id_praticante = :idPraticante\n" +
            ") AS subquery;\n", nativeQuery = true)
    public int verificarQuantidadeTotalDeCadastrosNaoFinalizadosDoPraticante(@Param("idPraticante") Long idPraticante);
}
