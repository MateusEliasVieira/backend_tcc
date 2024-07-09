package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;


import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.HabilidadesSociais;

public interface HabilidadesSociaisServico {
    public HabilidadesSociais salvarHabilidadesSociais(HabilidadesSociais habilidadesSociais);
    public HabilidadesSociais atualizarHabilidadesSociais(HabilidadesSociais habilidadesSociais);
    public HabilidadesSociais buscarHabilidadesSociaisPorId(Long idHabilidadesSociais);
}
