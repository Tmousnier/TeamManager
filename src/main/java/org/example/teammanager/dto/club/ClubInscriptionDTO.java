package org.example.teammanager.dto.club;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ClubInscriptionDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private LocalDate dateNaissance;
    private String nomClub;
    private String sport;
}