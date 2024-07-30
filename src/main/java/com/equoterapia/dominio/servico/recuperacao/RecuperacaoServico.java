package com.equoterapia.dominio.servico.recuperacao;

public interface RecuperacaoServico {
    public void enviarEmail(String para, String token) ;
    public void recuperarConta(String para) ;

}
