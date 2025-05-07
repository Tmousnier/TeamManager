package org.example.teammanager.model.equipeMatche;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EquipeMatcheId {
    private Integer idEquipe;
    private Integer idMatche;
}

