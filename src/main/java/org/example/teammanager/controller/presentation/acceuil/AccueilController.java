package org.example.teammanager.controller.presentation.acceuil;

import org.example.teammanager.dto.sport.SportEquipeDTO;
import org.example.teammanager.repository.club.ClubRepository;
import org.example.teammanager.repository.equipe.EquipeRepository;
import org.example.teammanager.repository.membre.MembreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.of;
import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("/api/accueil")
@CrossOrigin(origins = "http://localhost:5173") // Remplacez par l'URL de votre frontend
public class AccueilController {

    private static final Logger logger = LoggerFactory.getLogger(AccueilController.class);

    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    /**
     * Récupère les statistiques générales (nombre de membres, clubs et équipes).
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        try {
            Map<String, Object> stats = buildStatsMap();
            return ResponseEntity.ok(stats);  // Renvoie un objet JSON
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des statistiques : {}", e.getMessage(), e);
            return internalServerError().body(of("error", "Erreur lors de la récupération des statistiques"));
        }
    }

    /**Récupère le nombre d'équipes par sport.*/
    @GetMapping("/stats/sports")
    public ResponseEntity<Map<String, Long>> getStatsBySport() {
        try {
            List<SportEquipeDTO> stats = equipeRepository.countTeamsBySport();
            Map<String, Long> result = stats.stream()
                    .collect(Collectors.toMap(
                            SportEquipeDTO::getSportNom,
                            SportEquipeDTO::getNombreEquipes
                    ));

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des statistiques des sports : {}", e.getMessage(), e);
            return internalServerError().body(Collections.singletonMap("error", Long.valueOf("Erreur lors de la récupération des statistiques des sports")));
        }
    }

    /**
     * Construit une map contenant les statistiques globales.
     */
    private Map<String, Object> buildStatsMap() {
        try {
            return of(
                    "members", membreRepository.count(),
                    "clubs", clubRepository.count(),
                    "equipes", equipeRepository.count()
            );
        } catch (Exception e) {
            logger.error("Erreur lors de la construction de la map des statistiques : {}", e.getMessage(), e);
            throw new RuntimeException("Erreur lors de la construction de la map des statistiques", e);
        }
    }
}