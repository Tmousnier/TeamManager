package org.example.teammanager.dto.accueil;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class AccueilDTO {
    private long membresInscrits;
    private long clubsActifs;
    private long equipes;
}
