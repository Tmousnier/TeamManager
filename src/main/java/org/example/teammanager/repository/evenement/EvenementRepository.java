package org.example.teammanager.repository.evenement;

import org.example.teammanager.model.evenement.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    @Query("SELECT e FROM Evenement e JOIN e.equipe.equipeEvenements ee JOIN ee.equipe.clubEquipes ce WHERE ce.club.id = :clubId")
    List<Evenement> findAllByClubId(@Param("clubId") Integer clubId);
}