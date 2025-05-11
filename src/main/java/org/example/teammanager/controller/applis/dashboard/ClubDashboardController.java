package org.example.teammanager.controller.applis.dashboard;

import jakarta.servlet.http.HttpServletRequest;
import org.example.teammanager.config.JwtTokenProvider;
import org.example.teammanager.dto.membre.MembreConnexionDto;
import org.example.teammanager.model.clubMembre.ClubMembre;
import org.example.teammanager.model.equipeMembre.EquipeMembre;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.service.membre.MembreService;
import org.example.teammanager.service.membreRoleMembre.MembreRoleMembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/club-dashboard")
public class ClubDashboardController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private MembreService membreService;

    @Autowired
    private MembreRoleMembreService membreRoleMembreService;

    @GetMapping("/infos")
    public ResponseEntity<?> getMembreConnexionInfo(HttpServletRequest request) {
        String token = jwtTokenProvider.getTokenFromRequest(request);

        if (token == null || !jwtTokenProvider.validateToken(token)) {
            return ResponseEntity.status(401).body("Token JWT invalide ou manquant.");
        }

        String email = jwtTokenProvider.getUsernameFromToken(token);
        Membre membre = membreService.findByEmail(email).orElse(null);

        if (membre == null) {
            return ResponseEntity.status(404).body("Membre non trouvé.");
        }

        MembreRoleMembre membreRoleMembre = membreRoleMembreService.findByMembreId(membre).stream().findFirst().orElse(null);
        ClubMembre clubMembre = membre.getClubMembres().stream().findFirst().orElse(null);
        EquipeMembre equipeMembre = membre.getEquipeMembres().stream().findFirst().orElse(null);

        MembreConnexionDto dto = MembreConnexionDto.builder()
                .nom(membre.getNom())
                .prenom(membre.getPrenom())
                .idClub(clubMembre != null ? clubMembre.getClub().getId() : null)
                .nomClub(clubMembre != null ? clubMembre.getClub().getNom() : null)
                .idEquipe(equipeMembre != null ? equipeMembre.getEquipe().getIdEquipe() : null)
                .nomEquipe(equipeMembre != null ? equipeMembre.getEquipe().getNom() : null)
                .role(membreRoleMembre != null ? membreRoleMembre.getRoleMembre().getNomRole() : null)
                .build();

        return ResponseEntity.ok(dto);
    }
}
