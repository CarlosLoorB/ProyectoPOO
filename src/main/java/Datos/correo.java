/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author gabri
 */
public class correo {
    public static void enviarCorreo(String destinatario, String asunto, String contenido){
        String emisor = "grupo4POO@gmail.com";
        String clave = "grupo4123";
        
        Properties prope = System.getProperties();
        prope.put("mail.smtp.host", "smtp.gmail.com");
        prope.put("mail.smtp.user", emisor);
        prope.put("mail.smtp.auth", "true");
        prope.put("mail.smtp.starttls.enable", "true");
        prope.put("mail.smtp.port", "587");
        
        Session session = Session.getDefaultInstance(prope);
        MimeMessage message = new MimeMessage(session);
        
        try {
        message.setFrom(new InternetAddress(emisor));
        message.addRecipients(Message.RecipientType.TO, destinatario);
        message.setText(contenido);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", emisor, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("Correo enviado con exito");
        }
        catch (MessagingException me) {
        me.printStackTrace();  
    }
    }
}
