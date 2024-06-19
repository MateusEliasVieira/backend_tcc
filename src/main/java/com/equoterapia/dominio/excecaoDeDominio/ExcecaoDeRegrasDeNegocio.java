package com.equoterapia.dominio.excecaoDeDominio;

public class ExcecaoDeRegrasDeNegocio extends RuntimeException{
    public ExcecaoDeRegrasDeNegocio(String mensagem){
        super(mensagem);
    }
}
