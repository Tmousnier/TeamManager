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
@RequestMapping("/api/clubs/{clubId}")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/events")
    public ResponseEntity<List<EvenementDto>> getClubEvents(@PathVariable Integer clubId) {
        List<EvenementDto> events = clubService.getEventsForClub(clubId);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MembreDto>> getClubMembers(String clubName) {
        List<MembreDto> members = clubService.getMembersForClub(clubName);
        return ResponseEntity.ok(members);
    }
}