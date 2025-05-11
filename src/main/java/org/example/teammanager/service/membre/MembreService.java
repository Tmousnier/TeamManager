package org.example.teammanager.service.membre;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.repository.membre.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Optional<Membre> findByEmail(String email) {
        return membreRepository.findByEmail(email);
    }
}