package org.example.teammanager.service.club;

import org.example.teammanager.dto.club.ClubDTO;
import org.example.teammanager.dto.evenement.EvenementDto;
import org.example.teammanager.dto.membre.MembreDto;
import org.example.teammanager.dto.notification.NotificationDto;
import org.example.teammanager.dto.roleMembre.RoleMembreDto;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.clubMembre.ClubMembre;
import org.example.teammanager.model.evenement.Evenement;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.notification.Notification;
import org.example.teammanager.repository.club.ClubRepository;
import org.example.teammanager.repository.clubMembre.ClubMembreRepository;
import org.example.teammanager.repository.evenement.EvenementRepository;
import org.example.teammanager.repository.membre.MembreRepository;
import org.example.teammanager.repository.notification.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private ClubMembreRepository clubMembreRepository;
    @Autowired
    private NotificationRepository notificationRepository;

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
    public ClubDTO updateClub(Integer id, ClubDTO clubDTO) {
        return clubRepository.findById(id)
                .map(club -> {
                    club.setNom(clubDTO.getNom());
                    club.setVille(clubDTO.getVille());
                    club.setDateCreation(LocalDate.from(clubDTO.getDateCreation()));
                    club.setDescription(clubDTO.getDescription());
                    club.setPays(clubDTO.getPays());
                    club.setNumeroTelephone(clubDTO.getNumeroTelephone());
                    return convertToDTO(clubRepository.save(club));
                })
                .orElse(null);
    }

    public List<EvenementDto> getEventsForClub(String nomClub) {
        Club club = clubRepository.findByNom(nomClub);
        if(club == null) return List.of();
        return evenementRepository.findAllByClubId(club.getId())
                .stream()
                .filter(Objects::nonNull)
                .map(Evenement.class::cast)
                .map(this::evenementConvertToDto)
                .collect(Collectors.toList());
    }

    public List<MembreDto> getMembersForClub(String nomClub) {
        Optional<ClubMembre> clubMembres = clubMembreRepository.findByClub_Nom(nomClub); // Corrected method name
        if(clubMembres.isEmpty()) return List.of();
        return clubMembres.stream()
                .map(cm -> {
                    Membre membre = cm.getMembre();
                    MembreDto dto = new MembreDto();
                    dto.setId(Math.toIntExact(membre.getIdMembre()));
                    dto.setNom(membre.getNom());
                    dto.setPrenom(membre.getPrenom());
                    membre.getMembreRoleMembres()
                            .stream()
                            .findFirst()
                            .ifPresent(mr -> {
                                RoleMembreDto roleDto = new RoleMembreDto();
                                roleDto.setNomRole(mr.getRoleMembre().getNomRole());
                                dto.setRoleMembre(String.valueOf(roleDto));
                            });
                    dto.setStatut(membre.getStatut());

                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<NotificationDto> getNotificationsForClub(String nomClub) {
        List<Notification> notifications = notificationRepository.findByNomClub(nomClub);
        return notifications.stream()
                .map(this::notificationConvertToDto)
                .collect(Collectors.toList());
    }

    private ClubDTO convertToDTO(Club club) {
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setNom(club.getNom());
        clubDTO.setVille(club.getVille());
        clubDTO.setDateCreation(club.getDateCreation().atStartOfDay());
        clubDTO.setDescription(club.getDescription());
        clubDTO.setPays(club.getPays());
        clubDTO.setNumeroTelephone(club.getNumeroTelephone());
        return clubDTO;
    }

    private Club convertToEntity(ClubDTO clubDTO) {
        Club club = new Club();
        club.setNom(clubDTO.getNom());
        club.setVille(clubDTO.getVille());
        club.setDateCreation(LocalDate.from(clubDTO.getDateCreation()));
        club.setDescription(clubDTO.getDescription());
        club.setPays(clubDTO.getPays());
        club.setNumeroTelephone(clubDTO.getNumeroTelephone());
        return club;
    }

    private EvenementDto evenementConvertToDto(Evenement evenement) {
        EvenementDto dto = new EvenementDto();
        dto.setNom(evenement.getNom());
        dto.setDateDebut(evenement.getDateDebut().atStartOfDay(ZoneId.systemDefault()).toLocalDate());
        dto.setDateFin(evenement.getDateFin().atStartOfDay(ZoneId.systemDefault()).toLocalDate());
        dto.setLieux(evenement.getLieux());
        return dto;
    }

    private NotificationDto notificationConvertToDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setContenu(notification.getContenu());
        dto.setDate(notification.getDate());
        return dto;
    }
}