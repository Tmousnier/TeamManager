package org.example.teammanager.dto.club;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ClubDTO {
    private String nom; // Private fields are generally preferred
    private String ville;
    private String address;
    private LocalDateTime dateCreation;
    private String description;
    private String pays;
    private String adresse;
    private String numeroTelephone; // Consistent naming (camelCase)

    public ClubDTO() {}
}