package org.example.teammanager.model.equipeEvenement;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EquipeEvenementId implements Serializable {
    private Integer idEquipe;
    private Integer idEvenement;
}
