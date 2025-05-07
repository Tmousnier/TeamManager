package org.example.teammanager.service.club;

import org.example.teammanager.dto.club.ClubDTO;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.repository.club.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;
    public List<ClubDTO> getAllClubs() {
        return clubRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public Optional<ClubDTO> getClubById(Integer id) {
        return clubRepository.findById(id).map(this::convertToDTO);
    }
    public ClubDTO createClub(ClubDTO clubDTO) {
        Club club = convertToEntity(clubDTO);
        Club savedClub = clubRepository.save(club);
        return convertToDTO(savedClub);
    }
    public void deleteClub(Integer id) {clubRepository.deleteById(id);}
    private ClubDTO convertToDTO(Club club) {
        ClubDTO dto = new ClubDTO();
        dto.setNom(club.getNom());
        dto.setVille(club.getVille());
        dto.setAddresse(club.getAddresse());
        dto.setDateCreation(club.getDateCreation());
        dto.setDescription(club.getDescription());
        dto.setPays(club.getPays());
        dto.setNumeroTelephone(club.getNumeroTelephone());
        return dto;
    }
    private Club convertToEntity(ClubDTO clubDTO) {
        Club club = new Club();
        club.setNom(clubDTO.getNom());
        club.setVille(clubDTO.getVille());
        club.setAddresse(clubDTO.getAddresse());
        club.setDateCreation(clubDTO.getDateCreation());
        club.setDescription(clubDTO.getDescription());
        club.setPays(clubDTO.getPays());
        club.setNumeroTelephone(clubDTO.getNumeroTelephone());
        return club;
    }
}