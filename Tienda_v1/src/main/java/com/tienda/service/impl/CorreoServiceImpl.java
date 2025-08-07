package com.tienda.service.impl;

import com.tienda.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillen.kenneth
 */
@Slf4j
@Service
public class CorreoServiceImpl implements CorreoService{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviarCorreoHtml(String para, String asunto, String contenidoHtml) throws MessagingException {
        try {
            log.info("Intentando enviar correo a: {}", para);
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            helper.setTo(para);
            helper.setSubject(asunto);
            helper.setText(contenidoHtml, true);
            
            mailSender.send(message);
            
            log.info("Correo enviado exitosamente a: {}", para);
        } catch (MessagingException e) {
            log.error("Error al enviar correo a {}: {}", para, e.getMessage());
            throw e;
        }
    }
}
