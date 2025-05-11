package org.example.teammanager.dto;


public class JetonJwtResponse {
    public final String token;
    public final String email;
    public final String role;
    public final String nomClub;
    public final String nomEquipe;
    public final String prenom;
    public final String nom;

    public JetonJwtResponse(String token, String email, String role, String nomClub, String nomEquipe, String prenom, String nom) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.nomClub = nomClub;
        this.nomEquipe = nomEquipe;
        this.prenom = prenom;
        this.nom = nom;
    }
}