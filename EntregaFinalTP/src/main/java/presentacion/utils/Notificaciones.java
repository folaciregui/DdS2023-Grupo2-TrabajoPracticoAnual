package presentacion.utils;



import dominio.servicios.Incidente;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Objects;
import java.util.Properties;


public class Notificaciones {
    public void enviarEmail(String email, String motivo, Incidente incidente){
        final String userName = "dds23grupo2@gmail.com"; //same fromMail
        final String password = "Grupo2_2023";
        final String toEmail = email;
        String mensaje = "";

        if(Objects.equals(motivo, "APERTURA")){
            mensaje = "El incidente de id " + incidente.getId() + " fue ABIERTO.";
        }
        else if(Objects.equals(motivo, "CIERRE")){
            mensaje = "El incidente de id " + incidente.getId() + " fue CERRADO.";
        }

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        //props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // props.put("mail.smtp.ssl.enable", "true");
        // props.put("mail.smtp.socketFactory.port", "587"); //TLS Port

        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("dds23grupo2@gmail.com", "sueoxonaazhcawqm");

            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, true));
            message.setSubject("Aviso de notificacion");
            message.setText(mensaje);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        }catch (MessagingException me){
            System.out.println("Exception: "+me);

        }
    }
}
