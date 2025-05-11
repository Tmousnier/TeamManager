package org.example.teammanager.dto.membre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MembreConnexionDto {
    private String nom;
    private String prenom;
    private Integer idClub;
    private String nomClub;
    private Integer idEquipe;
    private String nomEquipe;
    private String role;

}
