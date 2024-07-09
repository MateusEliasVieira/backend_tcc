package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminado;

public interface RelacaoFamiliarExaminadoServico {
    public RelacaoFamiliarExaminado salvarRelacaoFamiliarExaminado(RelacaoFamiliarExaminado relacaoFamiliarExaminado);
    public RelacaoFamiliarExaminado atualizarRelacaoFamiliarExaminado(RelacaoFamiliarExaminado relacaoFamiliarExaminado);
    public RelacaoFamiliarExaminado buscarRelacaoFamiliarExaminadoPorId(Long idRelacaoFamiliarExaminado);
}
