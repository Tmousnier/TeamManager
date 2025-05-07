package org.example.teammanager.dto.club;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ClubDTO {
    private String nom;
    private String ville;
    private String addresse;
    private LocalDateTime dateCreation;
    private String description;
    private String pays;
    private String numeroTelephone; // Consistent naming (camelCase)

    public ClubDTO() {}
}