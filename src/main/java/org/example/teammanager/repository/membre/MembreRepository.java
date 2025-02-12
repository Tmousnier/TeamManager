package org.example.teammanager.repository.membre;

import org.example.teammanager.model.membre.Membre;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MembreRepository {

    public Optional<Membre> findByEmail(String email) {
        return null;
    }
}
