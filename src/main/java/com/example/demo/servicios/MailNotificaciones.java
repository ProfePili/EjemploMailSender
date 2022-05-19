package com.example.demo.servicios;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailNotificaciones {

    @Autowired
    private JavaMailSender jms;
    
    @Async
    public void mailSender(String email, String titulo, String descripcion){
        SimpleMailMessage mensaje = new SimpleMailMessage();
        
        mensaje.setTo(email);
        mensaje.setSubject(titulo);
        mensaje.setText(descripcion);
        mensaje.setSentDate(new Date());
        
        jms.send(mensaje);
    }
}
