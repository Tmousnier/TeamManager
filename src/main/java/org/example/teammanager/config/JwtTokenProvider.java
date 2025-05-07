package org.example.teammanager.config;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final long JWT_EXPIRATION_MS = 3600000; // 1 heure

    @Value("${jwt.secret}")
    private String jwtSecret;

    /**
     * Génère un JWT à partir des informations du membre.
     *
     * @param membreRoleMembre Le membre pour lequel générer le token
     * @return Le token JWT généré
     */
    public String generateToken(MembreRoleMembre membreRoleMembre) {
        return Jwts.builder()
                .setSubject(membreRoleMembre.getMembre().getEmail())
                .claim("roles", List.of(membreRoleMembre.getRoleMembre().getNomRole())) // Assurer que les rôles sont une liste
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Récupère le token JWT depuis la requête HTTP.
     *
     * @param request La requête HTTP
     * @return Le token JWT ou null si absent
     */
    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Extrait le token sans le préfixe "Bearer "
        }
        return null;
    }

    /**
     * Valide un token JWT.
     *
     * @param token Le token JWT à valider
     * @return true si le token est valide, false sinon
     */
    public boolean validateToken(String token) {
        try {
            // Vérification de la validité du token
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            throw new JwtExpiredException();
        } catch (UnsupportedJwtException ex) {
            throw new JwtUnsupportedException();
        } catch (MalformedJwtException ex) {
            throw new JwtMalformedException();
        } catch (SignatureException ex) {
            throw new JwtSignatureException();
        } catch (IllegalArgumentException ex) {
            throw new JwtInvalidArgumentException();
        }
    }

    /**
     * Récupère le nom d'utilisateur (email) depuis le token JWT.
     *
     * @param token Le token JWT
     * @return L'email du membre
     */
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    /**
     * Récupère les rôles depuis le token JWT.
     *
     * @param token Le token JWT
     * @return La liste des rôles
     */
    public List<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        List<String> roles = (List<String>) claims.get("roles");
        return roles;
    }

    // Exceptions personnalisées
    public static class JwtAuthenticationException extends RuntimeException {
        public JwtAuthenticationException(String message) {
            super(message);
        }
    }
    public static class JwtExpiredException extends JwtAuthenticationException {
        public JwtExpiredException() {
            super("JWT expired");
        }
    }
    public static class JwtUnsupportedException extends JwtAuthenticationException {
        public JwtUnsupportedException() {
            super("JWT unsupported");
        }
    }
    public static class JwtMalformedException extends JwtAuthenticationException {
        public JwtMalformedException() {
            super("JWT malformed");
        }
    }
    public static class JwtSignatureException extends JwtAuthenticationException {
        public JwtSignatureException() {
            super("JWT signature invalid");
        }
    }
    public static class JwtInvalidArgumentException extends JwtAuthenticationException {
        public JwtInvalidArgumentException() {
            super("JWT arguments invalid");
        }
    }
}