package com.equoterapia.utilidades;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {

    public static final String formateMinhaData(Date data) {
        if (data != null) {
            // Criar um formato desejado
            SimpleDateFormat meuFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            // Formatar a data em uma string
            String dataFormatada = meuFormato.format(data);
            return dataFormatada;
        }else{
            System.out.println("Data ta nula na classe FormataData");
            throw new ExcecaoDeRegrasDeNegocio("Erro interno do sistema!");
        }
    }

}
