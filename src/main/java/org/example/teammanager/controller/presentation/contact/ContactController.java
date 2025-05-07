package org.example.teammanager.controller.presentation.contact;

import org.example.teammanager.dto.contact.MessageErreurResponse;
import org.example.teammanager.dto.contact.ContactDto;
import org.example.teammanager.service.Presentation.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.MailException;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
@Validated
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> envoyerMessage(@Valid @RequestBody ContactDto contactDto) { // Ajout de @Valid
        try {
            emailService.envoyerEmail(contactDto.getNom(), contactDto.getPrenom(), contactDto.getEmail(), contactDto.getSujet(), contactDto.getMessage());
            return ResponseEntity.ok(new MessageErreurResponse("Message envoyé avec succès !"));
        } catch (MailException e) {
            return ResponseEntity.status(500).body(new MessageErreurResponse("Erreur lors de l'envoi de l'e-mail. Veuillez réessayer plus tard."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MessageErreurResponse("Une erreur inattendue s'est produite."));
        }
    }
}