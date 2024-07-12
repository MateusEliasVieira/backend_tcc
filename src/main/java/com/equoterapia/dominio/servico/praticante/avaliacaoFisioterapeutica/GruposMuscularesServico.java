package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.GruposMusculares;

public interface GruposMuscularesServico {
    public GruposMusculares salvarGruposMusculares(GruposMusculares gruposMusculares);
    public GruposMusculares atualizarGruposMusculares(GruposMusculares gruposMusculares);
    public GruposMusculares buscarGruposMuscularesPorId(Long idGruposMusculares);
}
