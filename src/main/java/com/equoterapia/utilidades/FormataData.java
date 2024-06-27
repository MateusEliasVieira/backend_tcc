package com.equoterapia.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {

    public static final String formateMinhaData(Date date) {
        // Criar um formato desejado
        SimpleDateFormat meuFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Formatar a data em uma string
        String dataFormatada = meuFormato.format(date);
        return dataFormatada;
    }

}
