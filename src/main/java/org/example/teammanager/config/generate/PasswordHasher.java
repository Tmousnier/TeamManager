package org.example.teammanager.config.generate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class PasswordHasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.print("Entrez votre mot de passe : ");
        String rawPassword = scanner.nextLine();

        String hashedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Mot de passe hashé : " + hashedPassword);

        scanner.close();
    }
}
