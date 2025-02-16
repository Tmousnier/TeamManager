package org.example.teammanager.controller.presentation.club;

import org.example.teammanager.model.club.Club;
import org.example.teammanager.service.clubService.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/listBySport/{sportNom}")
    public List<Club> getClubsBySport(@PathVariable String sportNom) {
        return clubService.getClubsBySport(sportNom);  // Retourne la liste des clubs pour le sport donné
    }
}
