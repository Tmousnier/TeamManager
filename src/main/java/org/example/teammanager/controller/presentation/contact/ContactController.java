package org.example.teammanager.controller.presentation.contact;

import org.example.teammanager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> envoyerMessage(@RequestBody Map<String, String> request) {
        String nom = request.get("nom");
        String prenom = request.get("prenom");
        String email = request.get("email");
        String sujet = request.get("sujet");
        String message = request.get("message");

        try {
            emailService.envoyerEmail(nom, prenom, email, sujet, message);
            return ResponseEntity.ok(Map.of("message", "Message envoyé avec succès !"));
        } catch (Exception e) {
            // Ajouter un message plus clair dans l'exception
            return ResponseEntity.status(500).body(Map.of("message", "Erreur lors de l'envoi du message : " + e.getMessage()));
        }
    }
}