package org.example.teammanager.service.membre;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.repository.membre.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void enregistrerMembre(Membre membre) {
        String motDePasseHache = passwordEncoder.encode(membre.getPassword());
        membre.setPassword(motDePasseHache);
        membreRepository.save(membre);
    }
    public Optional<Membre> findByEmail(String email) {
        return membreRepository.findByEmail(email); // <-- This call will now work
    }
    public long countAllMembers() {
        return membreRepository.count();
    }
}