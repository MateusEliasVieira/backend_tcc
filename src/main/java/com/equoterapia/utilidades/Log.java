package com.equoterapia.utilidades;

import com.equoterapia.api.dto.login.LoginEntradaDTO;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {

    public static void registrarLog(LoginEntradaDTO loginEntradaDTO, HttpServletRequest request) {
        try {
            String dataRequest = getDadosDaRequisicao(loginEntradaDTO, request);

            File file = new File("log.txt");
            FileWriter fileWriter = new FileWriter(file, true);

            fileWriter.append(dataRequest);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String getDadosDaRequisicao(LoginEntradaDTO loginEntradaDTO, HttpServletRequest request) {
        Date data = new Date();

        // Obtém o User-Agent do cabeçalho da requisição
        String usuarioAgenteTexto = request.getHeader("User-Agent");

        // Analisa o User-Agent usando a biblioteca UserAgentUtils
        UserAgent usuarioAgente = UserAgent.parseUserAgentString(usuarioAgenteTexto);

        // Obtém informações sobre o sistema operacional e navegador
        OperatingSystem sistemaOperacional = usuarioAgente.getOperatingSystem();
        Browser browser = usuarioAgente.getBrowser();

        // Obtém o nome do sistema operacional
        String so = sistemaOperacional.getName();

        // Obtém o nome do navegador
        String browserClient = browser.getName();

        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        String enderecoIpDoCliente = "";
        if (xForwardedForHeader == null) {
            enderecoIpDoCliente = request.getRemoteAddr();
        } else {
            // O cabeçalho X-Forwarded-For pode conter uma lista de endereços IP, onde o primeiro endereço é o endereço do cliente.
            enderecoIpDoCliente = xForwardedForHeader.split(",")[0].trim();
        }
        return "Data: " + FormataData.formateMinhaData(data) + ", IP: " + enderecoIpDoCliente + ", Navegador: " + browserClient + ", Sistema Operacional: " + so + " Login = (Nome de Usuário: " + loginEntradaDTO.getNomeUsuario() + ", Senha: " + loginEntradaDTO.getSenha() + ")\n";
    }


}
