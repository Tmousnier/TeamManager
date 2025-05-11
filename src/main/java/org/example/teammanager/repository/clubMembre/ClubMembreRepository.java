package org.example.teammanager.repository.clubMembre;

import org.example.teammanager.model.clubMembre.ClubMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubMembreRepository extends JpaRepository<ClubMembre, Integer> {
    Optional<ClubMembre> findByClub_Nom(String nom); // Corrected method name
}