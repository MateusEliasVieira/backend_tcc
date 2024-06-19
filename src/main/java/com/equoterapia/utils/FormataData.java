package com.equoterapia.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {

    public static final String formateMinhaData(Date date) {
        // Criar um formato desejado
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Formatar a data em uma string
        String dateFormat = myFormat.format(date);
        return dateFormat;
    }

}
