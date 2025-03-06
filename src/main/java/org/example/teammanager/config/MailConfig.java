package org.example.teammanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");  // Utilise le SMTP de ton fournisseur (ici Gmail)
        mailSender.setPort(587); // Port SMTP de Gmail
        mailSender.setUsername("mousniert.pro@gmail.com"); // Remplace par ton email
        mailSender.setPassword("oeuu dfdb eipr lann"); // Utilise un mot de passe d'application

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
