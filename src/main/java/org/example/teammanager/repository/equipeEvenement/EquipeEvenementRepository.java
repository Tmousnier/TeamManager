package org.example.teammanager.repository.equipeEvenement;

import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.equipeEvenement.EquipeEvenement;
import org.example.teammanager.model.equipeEvenement.EquipeEvenementId;
import org.example.teammanager.model.evenement.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EquipeEvenementRepository extends JpaRepository<EquipeEvenement, EquipeEvenementId> {

    @Query("SELECT ee.equipe FROM EquipeEvenement ee WHERE ee.evenement.idEvenement = :evenementId")
    List<Equipe> findTeamsByEventId(@Param("evenementId") int evenementId);


}