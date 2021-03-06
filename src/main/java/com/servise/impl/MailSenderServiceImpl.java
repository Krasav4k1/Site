package com.servise.impl;

import com.servise.MailSenderService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@org.springframework.stereotype.Service
public class MailSenderServiceImpl implements MailSenderService {

    final static String USERNAME = "Krasav4k1@gmail.com";
    final static String PASSWORD = "@@@Krasav4k@@@";
    final static String EMAILFROM = "Krasav4k1@gmail.com";

    public synchronized void sendMail(String content, String email, String path){
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.class","468");
        properties.setProperty("mail.smpt.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAILFROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(EMAILFROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(content, "UTF-8");
            message.setText(path);
            Transport.send(message);
            System.out.println("Messege send from Krasav4k");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("exxaptions");
        }


    }

}
