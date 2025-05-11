package org.example.teammanager.controller.applis.club;

import org.example.teammanager.dto.evenement.EvenementDto;
import org.example.teammanager.dto.membre.MembreDto;
import org.example.teammanager.service.club.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clubs/{nomClub}")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/events")
    public ResponseEntity<List<EvenementDto>> getClubEvents(@PathVariable String nomClub) {
        List<EvenementDto> events = clubService.getEventsForClub(nomClub);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MembreDto>> getClubMembers(@PathVariable String nomClub) {
        List<MembreDto> members = clubService.getMembersForClub(nomClub);
        return ResponseEntity.ok(members);
    }
}