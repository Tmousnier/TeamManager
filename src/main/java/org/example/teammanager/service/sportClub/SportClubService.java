package org.example.teammanager.service.sportClub;

import org.example.teammanager.dto.club.ClubDTO;
import org.example.teammanager.dto.sport.SportDTO;
import org.example.teammanager.dto.sportClub.SportClubDTO;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.sport.Sport;
import org.example.teammanager.model.sportClub.SportClub;
import org.example.teammanager.repository.sportClub.SportClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportClubService {

    @Autowired
    private SportClubRepository sportClubRepository;

    public List<SportClubDTO> getAllSportClubs() {
        return sportClubRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public List<SportClubDTO> getSportClubsByClubId(int idClub) {
        return sportClubRepository.findByClubId(idClub).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<SportClubDTO> getSportClubsBySportId(int idSport) {
        return sportClubRepository.findBySport_IdSport(idSport).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SportClubDTO convertToDTO(SportClub sportClub) {
        SportClubDTO dto = new SportClubDTO();
        // Convert Sport and Club entities to DTOs.  Important to avoid circular dependencies
        dto.setSport(convertSportToDTO(sportClub.getSport()));
        dto.setClub(convertClubToDTO(sportClub.getClub()));
        return dto;
    }

    private SportDTO convertSportToDTO(Sport sport) {
        SportDTO sportDTO = new SportDTO();
        sportDTO.setNom(sport.getNom());
        return sportDTO;
    }

    private ClubDTO convertClubToDTO(Club club) {
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setNom(club.getNom());
        clubDTO.setVille(club.getVille());
        clubDTO.setDateCreation(club.getDateCreation().atStartOfDay());
        clubDTO.setDescription(club.getDescription());
        clubDTO.setPays(club.getPays());
        clubDTO.setNumeroTelephone(club.getNumeroTelephone());
        return clubDTO;
    }

}