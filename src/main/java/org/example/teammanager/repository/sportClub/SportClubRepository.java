package org.example.teammanager.repository.sportClub;

import org.example.teammanager.model.sport.Sport;
import org.example.teammanager.model.sportClub.SportClub;
import org.example.teammanager.model.sportClub.SportClubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportClubRepository extends JpaRepository<SportClub, SportClubId> {

    List<SportClub> findByClubId(int idClub); //find all sports by club id
    List<SportClub> findBySportId(int idSport); //find all clubs by sport id
    @Query("SELECT s.id, s.nom, COUNT(sc.club) FROM Sport s LEFT JOIN SportClub sc ON s.id = sc.sport.id GROUP BY s.id, s.nom")
    List<Object> getAllSportsWithClubCount();


}