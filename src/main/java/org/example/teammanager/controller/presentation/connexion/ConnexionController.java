package org.example.teammanager.controller.presentation.connexion;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.teammanager.model.membre.Membre;
import org.springframework.beans.factory.annotation.Value; // Inject secret key
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/connexion")
public class ConnexionController {

    @Value("${jwt.secret}") // Inject the secret key from application.properties
    private String jwtSecret;
    private final MembreRepository membreRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ConnexionController(MembreRepository membreRepository, BCryptPasswordEncoder passwordEncoder) {
        this.membreRepository = membreRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Membre membre) {
        Optional<Membre> storedMembreOptional = membreRepository.findByEmail(membre.getEmail());
        if (storedMembreOptional.isEmpty()) {
            return ResponseEntity.status(401).body(new ErrorResponse("Invalid credentials")); // Return error object
        }

        Membre storedMembre = storedMembreOptional.get();
        if (passwordEncoder.matches(membre.getPassword(), storedMembre.getPassword())) {
            String jwt = generateJwtToken(membre.getEmail());  // Generate JWT
            return ResponseEntity.ok(new JwtResponse(jwt)); // Return JWT in a response object
        }
        return ResponseEntity.status(401).body(new ErrorResponse("Invalid credentials")); // Return error object
    }
    private String generateJwtToken(String email) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 86400000)) // Example: 24 hours validity
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // Use your secret key
                .compact();
    }
    private static class JwtResponse {
        public String token;
        public JwtResponse(String token) {
            this.token = token;
        }
    }
    private static class ErrorResponse {
        public String message;
        public ErrorResponse(String message) {
            this.message = message;
        }
    }
}