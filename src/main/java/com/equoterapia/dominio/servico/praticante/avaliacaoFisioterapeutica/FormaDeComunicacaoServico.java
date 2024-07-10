package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.FormaDeComunicacao;

public interface FormaDeComunicacaoServico {
    public FormaDeComunicacao salvarFormaDeComunicacao(FormaDeComunicacao formaDeComunicacao);

    public FormaDeComunicacao atualizarFormaDeComunicacao(FormaDeComunicacao formaDeComunicacao);

    public FormaDeComunicacao buscarFormaDeComunicacaoPorId(Long idFormaDeComunicacao);
}
