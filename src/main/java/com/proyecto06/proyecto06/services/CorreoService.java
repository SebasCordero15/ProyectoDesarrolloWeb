
package com.proyecto06.proyecto06.services;

import jakarta.mail.MessagingException;


public interface CorreoService {
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}

