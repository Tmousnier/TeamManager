package org.example.teammanager.controller.presentation.club;

import org.example.teammanager.dto.club.ClubInscriptionDTO;
import org.example.teammanager.mapper.ClubMapper;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembreId;
import org.example.teammanager.model.roleMembre.RoleMembre;
import org.example.teammanager.model.sport.Sport;
import org.example.teammanager.model.sportClub.SportClub;
import org.example.teammanager.repository.club.ClubRepository;
import org.example.teammanager.repository.membre.MembreRepository;
import org.example.teammanager.repository.membreRoleMembre.MembreRoleMembreRepository;
import org.example.teammanager.repository.roleMembre.RoleMembreRepository;
import org.example.teammanager.repository.sport.SportRepository;
import org.example.teammanager.repository.sportClub.SportClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/clubs")
public class ClubInscriptionController {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private SportRepository sportRepository;
    @Autowired
    private SportClubRepository sportClubRepository;
    @Autowired
    private MembreRoleMembreRepository membreRoleMembreRepository;
    @Autowired
    private RoleMembreRepository roleMembreRepository;
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/inscription")
    @Transactional
    public ResponseEntity<?> inscrireClub(@RequestBody ClubInscriptionDTO clubInscriptionDTO) {
        try {
            // Création du club
            if (clubRepository.existsByNom(clubInscriptionDTO.getNom())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom du club existe déjà.");
            }
            Club club = clubMapper.inscribe(clubInscriptionDTO);
            club.setDateCreation(LocalDate.now());
            club = clubRepository.save(club);
            // Création du membre
            Membre membre = new Membre();
            membre.setNom(clubInscriptionDTO.getNom());
            membre.setPrenom(clubInscriptionDTO.getPrenom());
            membre.setEmail(clubInscriptionDTO.getEmail());
            membre.setPassword(passwordEncoder.encode(clubInscriptionDTO.getPassword()));
            membre.setDateDeNaissance(clubInscriptionDTO.getDateNaissance());
            membreRepository.save(membre);

            Sport sport = sportRepository.findByNom(clubInscriptionDTO.getSport())
                    .orElseThrow(() -> new RuntimeException("Sport non trouvé"));

            SportClub sportClub = new SportClub();
            sportClub.setClub(club);
            sportClub.setSport(sport);
            sportClubRepository.save(sportClub);

            // Récupération du rôle "Dirigeant"
            RoleMembre roleDirigeant = roleMembreRepository.findByNomRole("Dirigeant")
                    .orElseThrow(() -> new RuntimeException("Rôle dirigeant non trouvé"));

            // Créer et enregistrer l'association MembreRoleMembre
            MembreRoleMembre membreRoleMembre = new MembreRoleMembre();
            membreRoleMembre.setMembre(membre);
            membreRoleMembre.setRoleMembre(roleDirigeant);
            membreRoleMembreRepository.save(membreRoleMembre);

            return ResponseEntity.status(HttpStatus.CREATED).body("Club et dirigeant créés avec succès.");

        } catch (RuntimeException e) {
            if (e.getMessage().equals("Sport non trouvé") || e.getMessage().equals("Rôle dirigeant non trouvé")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'inscription du club.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'inscription du club.");
        }
    }
}