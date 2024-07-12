package com.equoterapia.dominio.servico.praticante.planoTerapeuticoSingular;


import com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingular;

public interface PlanoTerapeuticoSingularServico {
    public PlanoTerapeuticoSingular salvarPlanoTerapeuticoSingular(PlanoTerapeuticoSingular planoTerapeuticoSingular);

    public PlanoTerapeuticoSingular atualizarPlanoTerapeuticoSingular(PlanoTerapeuticoSingular planoTerapeuticoSingular);

    public PlanoTerapeuticoSingular buscarPlanoTerapeuticoSingular(Long idPlanoTerapeuticoSingular);
}
