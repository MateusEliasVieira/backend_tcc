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
    public static final String verificarMes(int mes) {
        if (mes == 1) {
            return "Jan";
        } else if (mes == 2) {
            return "Fev";
        } else if (mes == 3) {
            return "Mar";
        } else if (mes == 4) {
            return "Abril";
        } else if (mes == 5) {
            return "Maio";
        } else if (mes == 6) {
            return "Jun";
        } else if (mes == 7) {
            return "Jul";
        } else if (mes == 8) {
            return "Ago";
        } else if (mes == 9) {
            return "Set";
        } else if (mes == 10) {
            return "Out";
        } else if (mes == 11) {
            return "Nov";
        } else if (mes == 12) {
            return "Dez";
        } else {
            return "";
        }
    }


}
