package com.equoterapia.dominio.servico.recuperacao.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import com.equoterapia.dominio.repositorio.usuario.UsuarioRepositorio;
import com.equoterapia.dominio.servico.recuperacao.RecuperacaoServico;
import com.equoterapia.seguranca.jwt.JwtToken;
import com.equoterapia.utilidades.HtmlEmail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class RecuperacaoServicoImpl implements RecuperacaoServico {

    @Value("${spring.mail.username}")
    private String MY_GMAIL;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void enviarEmail(String para, String token) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");

            // Define o destinatário, assunpara e o conteúdo HTML do e-mail
            helper.setTo(para);
            helper.setSubject("Confirmação de conta");

            // Codificando a string para Base64
            byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());

            // Convertendo os bytes codificados de volta para uma string
            String tokenBase64String = new String(encodedBytes);

            // Use HTML para criar um link estilizado
            String htmlContent = "<p>Por favor, clique no link abaixo para confirmar sua conta!</p>" +
                    "<p><a href=\"http://localhost:5173/confirmation?token=" + tokenBase64String + "\" style=\"color: #007BFF; text-decoration: none;\">Confirmar!</a></p>";
            helper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
        } catch (MailException | MessagingException e) {
            throw new ExcecaoDeRegrasDeNegocio("Erro ao enviar email para " + para);
        }

    }

    @Override
    public void recuperarConta(String para) {
        try {
            Usuario usuario = usuarioRepositorio.findByEmail(para).get();

            if (usuario != null) {
                // exist usuario

                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");

                // Define o destinatário, assunpara e o conteúdo HTML do e-mail
                helper.setTo(para);
                helper.setSubject("Recuperação de conta");

                String newToken = JwtToken.generateTokenJWT(usuario); // gerar novo token
                usuario.setToken(newToken); // atualizar token do usuario
                Usuario usuarioAtualizadoComNovoToken = usuarioRepositorio.save(usuario); // salvar mudanças
                String token = usuarioAtualizadoComNovoToken.getToken(); // obter o token atualizado

                // Use HTML para criar um link estilizado
                String HTML = new HtmlEmail().gerarHtmlDeEmail("http://localhost:3000/#/nova-senha?token=" + token);
                helper.setSubject("Equipe de Equoterapia");
                helper.setText(HTML, true);
                javaMailSender.send(mimeMessage);

            } else {
                // not exist usuario
                throw new ExcecaoDeRegrasDeNegocio("Não existe usuário cadastrado no sistema com o email informado!");
            }
        } catch (MailException | MessagingException e) {
            throw new ExcecaoDeRegrasDeNegocio("Erro ao recuperar conta para " + para);
        }

    }


}