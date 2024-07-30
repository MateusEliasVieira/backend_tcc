package com.equoterapia.utilidades;

public class HtmlEmail {

    public String gerarHtmlDeEmail(String link) {
        String botao = String.format(
                "        <a href='%s' style='\n" +
                "            display: block;\n" +
                "            width: 350px;\n" +
                "            height: 40px;\n" +
                "            background-color: #f01d35;\n" +
                "            font-size: 30px;\n" +
                "            text-align: center;\n" +
                "            color: white;\n" +
                "            padding: 10px;\n" +
                "            border-radius: 10px;\n" +
                "            text-decoration: none;\t\n" +
                "            margin: 20px auto;\n" +
                "            line-height: 40px;'>\n" +
                "            Recuperar minha conta!\n" +
                "        </a>\n",link);

        return botao;
    }
}


