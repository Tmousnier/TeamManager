package org.example.teammanager.service.sport;

import org.example.teammanager.dto.sport.SportDTO;
import org.example.teammanager.dto.sport.SportEquipeDTO;
import org.example.teammanager.model.sport.Sport;
import org.example.teammanager.repository.sport.SportRepository;
import org.example.teammanager.repository.sportClub.SportClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;
    @Autowired
    private SportClubRepository sportClubRepository;


    public List<SportDTO> getAllSports() {
        return sportRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public Optional<SportDTO> getSportById(Integer id) {
        return sportRepository.findById(id).map(this::convertToDTO);
    }
    public SportDTO createSport(SportDTO sportDTO) {
        Sport sport = convertToEntity(sportDTO);
        Sport savedSport = sportRepository.save(sport);
        return convertToDTO(savedSport);
    }
    public void deleteSport(Integer id) {
        sportRepository.deleteById(id);
    }
    private SportDTO convertToDTO(Sport sport) {
        SportDTO dto = new SportDTO();
        dto.setNom(sport.getNom());
        return dto;
    }
    private Sport convertToEntity(SportDTO sportDTO) {
        Sport sport = new Sport();
        sport.setNom(sportDTO.getNom());
        return sport;
    }

    public List<SportEquipeDTO> getAllSportsWithClubCount() {
        return sportClubRepository.getAllSportsWithClubCount().stream()
                .map(obj -> {
                    Object[] objects = (Object[]) obj; // Cast explicite
                    SportEquipeDTO dto = new SportEquipeDTO();
                    dto.setSportNom((String) objects[1]);
                    dto.setNombreEquipes((Long) objects[2]);
                    return dto;
                })
                .collect(Collectors.toList());
    }

}