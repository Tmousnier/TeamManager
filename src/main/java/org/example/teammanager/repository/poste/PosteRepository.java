package org.example.teammanager.repository.poste;

import org.example.teammanager.model.poste.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> {
    Optional<Poste> findByNom(String nom);
}