package org.example.teammanager.controller.presentation.rejoindreClub;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.repository.club.ClubRepository;
import org.example.teammanager.repository.equipe.EquipeRepository;
import org.example.teammanager.service.membreService.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class RejoindreClubController {

    @Autowired
    private MembreService membreService;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @PostMapping("api/rejoindre")
    public ResponseEntity<String> rejoindreEquipe(@RequestBody Membre membre) {
        try {
            // Recherche du club et de l'équipe
            Club club = clubRepository.findByNom(membre.getClub().getNom());
            Equipe equipe = equipeRepository.findByNom(membre.getEquipe().getNom());

            if (club == null || equipe == null) {
                return ResponseEntity.badRequest().body("Club ou équipe non trouvé.");
            }

            // Remplir les informations manquantes
            membre.setClub(club);
            membre.setEquipe(equipe);
            membre.setDateInscription(new Date());

            // Sauvegarder le membre dans la base de données
            membreService.saveMembre(membre);

            return ResponseEntity.ok("Membre ajouté avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de l'ajout du membre : " + e.getMessage());
        }
    }
}
