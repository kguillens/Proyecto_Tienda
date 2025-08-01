package com.tienda.service;

import jakarta.mail.MessagingException;

/**
 *
 * @author guillen.kenneth
 */
public interface CorreoService {

    public void enviarCorreoHtml(
            String para, // A quien se dirige el correo
            String asunto, // Titulo principal
            String contenidoHtml) // Cuerpo del correo
            throws MessagingException; // NO puede enviar el correo

}
