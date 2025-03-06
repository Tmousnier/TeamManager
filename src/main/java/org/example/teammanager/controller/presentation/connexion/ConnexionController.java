package org.example.teammanager.controller.presentation.connexion;

import org.example.teammanager.config.JwtTokenProvider;
import org.example.teammanager.dto.JetonJwtResponse;
import org.example.teammanager.dto.MessageErreurResponse;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.service.membre.MembreService;
import org.example.teammanager.service.membreRoleMembre.MembreRoleMembreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/connexion")
public class ConnexionController {

    private static final Logger logger = LoggerFactory.getLogger(ConnexionController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MembreService membreService;

    @Autowired
    private MembreRoleMembreService membreRoleMembreService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Membre membre) {
        try {
            Membre membreEnregistre = membreService.findByEmail(membre.getEmail()).orElseThrow();

            if (!passwordEncoder.matches(membre.getPassword(), membreEnregistre.getPassword())) {
                throw new BadCredentialsException("Identifiants incorrects");
            }

            List<MembreRoleMembre> membreRoleMembres = membreRoleMembreService.findByIdMembre(membreEnregistre);

            if (membreRoleMembres.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MessageErreurResponse("Rôle non trouvé pour ce membre"));
            }

            // Si plusieurs rôles existent, prenez le premier (vous pouvez changer cette logique si nécessaire)
            MembreRoleMembre membreRoleMembre = membreRoleMembres.get(0);

            String nomRole = membreRoleMembre.getIdRoleMembre().getNomRole();

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    membre.getEmail(),
                    membreEnregistre.getPassword(),
                    List.of(new SimpleGrantedAuthority(nomRole))
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jetonJwt = jwtTokenProvider.generateToken(membreRoleMembre);

            return ResponseEntity.ok(new JetonJwtResponse(
                    jetonJwt,
                    membreEnregistre.getEmail(),
                    authentication.getAuthorities().stream().findFirst().orElseThrow().getAuthority()
            ));

        } catch (AuthenticationException e) {
            String messageErreur = (e instanceof BadCredentialsException)
                    ? "Email ou mot de passe incorrect"
                    : "Erreur d'authentification";
            logger.error(messageErreur, e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageErreurResponse(messageErreur));
        } catch (Exception e) {
            logger.error("Erreur lors de l'authentification", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageErreurResponse("Une erreur est survenue lors de l'authentification."));
        }
    }
}