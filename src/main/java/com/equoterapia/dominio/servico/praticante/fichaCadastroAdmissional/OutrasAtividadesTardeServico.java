package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesTarde;

public interface OutrasAtividadesTardeServico {
    public OutrasAtividadesTarde salvarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde);
    public OutrasAtividadesTarde atualizarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde);
    public OutrasAtividadesTarde buscarOutrasAtividadesTardePorId(Long id);
}
