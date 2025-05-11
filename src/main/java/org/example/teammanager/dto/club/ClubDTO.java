package org.example.teammanager.dto.club;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDTO {
    private String nom;
    private String ville;
    private LocalDateTime dateCreation;
    private String description;
    private String pays;
    private String numeroTelephone;

}