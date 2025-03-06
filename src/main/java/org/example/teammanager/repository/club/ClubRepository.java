package org.example.teammanager.repository.club;

import org.example.teammanager.model.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
    Optional<Club> findByNom(String nom); // Example custom query


}