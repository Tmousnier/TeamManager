package org.example.teammanager.service.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void envoyerEmail(String nom, String prenom, String email, String sujet, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(email);
            messageHelper.setTo("mousnier.th@gmail.com");
            messageHelper.setSubject(sujet);
            // Utiliser le HTML généré par React Email (à remplacer par votre logique)
            String emailHtml = "<h1>De: " + nom + " " + prenom + " (" + email + ")</h1><p>Sujet: " + sujet + "</p><p>" + message + "</p>";
            messageHelper.setText(emailHtml, true);
        };

        try {
            mailSender.send(messagePreparator);
            logger.info("Email envoyé avec succès à {}", "mousniert.pro@gmail.com");
        } catch (Exception e) {
            logger.error("Erreur lors de l'envoi de l'email : {}", e.getMessage());
            throw new RuntimeException("Échec de l'envoi de l'email");
        }
    }
}