package org.example.teammanager.repository.clubMembre;

import org.example.teammanager.model.clubMembre.ClubMembre;
import org.example.teammanager.model.clubMembre.ClubMembreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubMembreRepository extends JpaRepository<ClubMembre, ClubMembreId> {
}
