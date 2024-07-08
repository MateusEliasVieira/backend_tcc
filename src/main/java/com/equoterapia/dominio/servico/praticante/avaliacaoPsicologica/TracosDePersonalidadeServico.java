package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.TracosDePersonalidade;

public interface TracosDePersonalidadeServico {
    public TracosDePersonalidade salvarTracosDePersonalidade(TracosDePersonalidade tracosDePersonalidade);
    public TracosDePersonalidade atualizarTracosDePersonalidade(TracosDePersonalidade tracosDePersonalidade);
    public TracosDePersonalidade buscarTracosDePersonalidadePorId(Long idTracosDePersonalidade);
}
