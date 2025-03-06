package org.example.teammanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void envoyerEmail(String nom, String prenom, String email, String sujet, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(email);
            mailMessage.setTo("mousnier.th@gmail.com");
            mailMessage.setSubject(sujet);
            mailMessage.setText("De: " + nom + " " + prenom + " (" + email + ")\n\n" + message);

            mailSender.send(mailMessage);
            logger.info("Email envoyé avec succès à {}", "mousniert.pro@gmail.com");
        } catch (Exception e) {
            logger.error("Erreur lors de l'envoi de l'email : {}", e.getMessage());
            throw new RuntimeException("Échec de l'envoi de l'email");
        }
    }
}
