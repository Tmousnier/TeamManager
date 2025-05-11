package org.example.teammanager.config.generate;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA512");
        keyGen.init(512); // Specify key size
        SecretKey secretKey = keyGen.generateKey();
        String base64EncodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        System.out.println("Generated Base64-Encoded Key: " + base64EncodedKey);
    }

}
