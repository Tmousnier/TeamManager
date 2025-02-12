package org.example.teammanager.controller.connexion;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.repository.membre.MembreRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class ConnexionController {
    @GetMapping("/login")
    public String loginPage() {return "login";}
    private final MembreRepository membreRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ConnexionController(MembreRepository membreRepository, BCryptPasswordEncoder passwordEncoder) {
        this.membreRepository = membreRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Membre membre) {
        Optional<Membre> storedMembreOptional = membreRepository.findByEmail(membre.getEmail());
        if (storedMembreOptional.isEmpty()) {return ResponseEntity.status(401).body("Invalid credentials");}
        Membre storedMembre = storedMembreOptional.get();
        if (passwordEncoder.matches(membre.getPassword(), storedMembre.getPassword())) {return ResponseEntity.ok("Login successful");}
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}