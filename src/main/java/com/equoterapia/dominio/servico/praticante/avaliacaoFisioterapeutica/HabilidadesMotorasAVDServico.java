package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVD;

public interface HabilidadesMotorasAVDServico {
    public HabilidadesMotorasAVD salvarHabilidadesMotorasAVD(HabilidadesMotorasAVD habilidadesMotorasAVD);
    public HabilidadesMotorasAVD atualizarHabilidadesMotorasAVD(HabilidadesMotorasAVD habilidadesMotorasAVD);
    public HabilidadesMotorasAVD buscarHabilidadesMotorasAVDPorId(Long idHabilidadesMotorasAVD);
}
