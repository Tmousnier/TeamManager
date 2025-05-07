package org.example.teammanager.repository.club;

import org.example.teammanager.model.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
    boolean existsByNom(String code);
}