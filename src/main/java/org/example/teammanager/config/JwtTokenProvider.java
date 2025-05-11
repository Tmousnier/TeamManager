// src/main/java/org/example/teammanager/config/JwtTokenProvider.java
package org.example.teammanager.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final long JWT_EXPIRATION_MS = 86400000;

    private final byte[] signingKey;

    public JwtTokenProvider(JwtConfig jwtConfig) {
        try {
            this.signingKey = Base64.getDecoder().decode(jwtConfig.getSecret());
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("La clé JWT n'est pas encodée en Base64 ou est invalide.", e);
        }
    }

    @PostConstruct
    public void logKeyInfo() {
        System.out.println("[INFO] Clé JWT correctement chargée (" + signingKey.length + " octets).");
    }

    public String generateToken(MembreRoleMembre membreRoleMembre) {
        return Jwts.builder()
                .setSubject(membreRoleMembre.getMembre().getEmail())
                .claim("roles", List.of(membreRoleMembre.getRoleMembre().getNomRole()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .compact();
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token);
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

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public List<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).getBody();
        return (List<String>) claims.get("roles");
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
