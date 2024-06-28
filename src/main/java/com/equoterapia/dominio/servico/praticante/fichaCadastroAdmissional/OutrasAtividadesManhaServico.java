package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesManha;

public interface OutrasAtividadesManhaServico {
    public OutrasAtividadesManha salvarOutrasAtividadesManha(OutrasAtividadesManha outrasAtividadesManha);
    public OutrasAtividadesManha atualizarOutrasAtividadesManha(OutrasAtividadesManha outrasAtividadesManha);
    public OutrasAtividadesManha buscarOutrasAtividadesManhaPorId(Long id);
}
