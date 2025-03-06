package org.example.teammanager.repository.sport;

import org.example.teammanager.model.sport.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
    Optional<Sport> findByNom(String nom);
}