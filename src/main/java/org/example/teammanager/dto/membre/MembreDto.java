package org.example.teammanager.dto.membre;

import lombok.Data;

@Data
public class MembreDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String genre;
    private String dateDeNaissance;
    private String email;
    private Integer numeroTelephone;
    private String password;
    private String dateInscription;
    private String statut;
    private String roleMembre;
}
