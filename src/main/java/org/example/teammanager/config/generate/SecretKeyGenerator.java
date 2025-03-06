package org.example.teammanager.config.generate;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        // Générer une clé secrète stable pour le JWT
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[64]; // Choisir une taille de clé (par exemple, 64 octets)
        random.nextBytes(key);

        // Convertir la clé en Base64
        String base64Key = Base64.getEncoder().encodeToString(key);

        // Afficher la clé générée
        System.out.println("Clé secrète JWT : " + base64Key);
    }
}
