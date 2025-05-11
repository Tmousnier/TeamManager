package org.example.teammanager.service.Dashboard;

import java.util.List;
import java.util.Optional;

import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.repository.club.ClubRepository;
import org.example.teammanager.repository.equipe.EquipeRepository;
import org.example.teammanager.repository.evenement.EvenementRepository;
import org.example.teammanager.repository.matche.MatcheRepository;
import org.example.teammanager.repository.membre.MembreRepository;
import org.example.teammanager.repository.message.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
/*
    @Autowired
    private MembreRepository membreRepo;
    @Autowired
    private ClubRepository clubRepo;
    @Autowired
    private EquipeRepository equipeRepo;
    @Autowired
    private MatcheRepository matcheRepository;
    @Autowired
    private EvenementRepository eventRepo;
    @Autowired
    private MessageRepository messageRepo;

    public DashboardResponse getDashboardForUser(String email) {
        Optional<Membre> membre = membreRepo.findByEmail(email);
        if (membre.isEmpty()) return null;

        DashboardResponse response = new DashboardResponse();
        String role = membre.getDtype(); // Joueur, Responsable, etc.
        response.setRole(role);

        Club club = clubRepo.findByMembreId(membre.get().getId());
        response.setNomClub(club != null ? club.getNom() : null);

        List<Equipe> equipes = equipeRepo.findByMembreId(membre.get().getId());

        if (role.equalsIgnoreCase("Responsable")) {
            // DIRIGEANT
            response.setNombreMembres(clubRepo.countMembres(club.getId()));
            response.setNombreEquipes(clubRepo.countEquipes(club.getId()));
            response.setNombreMatchs(clubRepo.countMatchs(club.getId()));
            response.setNombreEvenements(clubRepo.countEvenements(club.getId()));
            response.setMessagesRecents(messageRepo.findLastMessagesByClubId(club.getId()));
        } else {
            // MEMBRE EQUIPE
            if (equipes.isEmpty()) return response;

            Equipe equipe = equipes.get(0);
            response.setNomEquipe(equipe.getNom());
            response.setNombreMembres(equipeRepo.countMembres(equipe.getId()));
            response.setNombreMatchs(matcheRepository.countMatchsByEquipe(equipe.getId()));
            response.setNombreEvenements(eventRepo.countEvenementsByEquipe(equipe.getId()));
            response.setMessagesRecents(messageRepo.findLastMessagesByEquipeId(equipe.getId()));
        }

        return response;
    }
*/
}
