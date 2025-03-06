package org.example.teammanager.repository.equipe;

import org.example.teammanager.dto.sport.SportEquipeDTO;
import org.example.teammanager.model.equipe.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    @Query("SELECT new org.example.teammanager.dto.sport.SportEquipeDTO(s.nom, COUNT(e)) " +
            "FROM Sport s " +
            "JOIN SportClub sc ON sc.sport = s " +
            "JOIN Club c ON sc.club = c " +
            "JOIN ClubMembre cm ON cm.club = c " +
            "JOIN Membre m ON cm.membre = m " +
            "JOIN EquipeMembre em ON em.membre = m " +
            "JOIN Equipe e ON em.equipe = e " +
            "GROUP BY s.nom")
    List<SportEquipeDTO> countTeamsBySport();
}