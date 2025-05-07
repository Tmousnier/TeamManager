package org.example.teammanager.repository.evenement;

import org.example.teammanager.model.evenement.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    @Query("SELECT ee.evenement FROM EquipeEvenement ee WHERE ee.equipe.id = :equipeId")
    List<Evenement> findByEquipeId(@Param("equipeId") int equipeId);
}