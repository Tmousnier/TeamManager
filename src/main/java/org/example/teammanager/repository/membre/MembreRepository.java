package org.example.teammanager.repository.membre;

import org.example.teammanager.model.membre.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Integer> {
    Optional<Membre> findByEmail(String email);
}
