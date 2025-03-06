package org.example.teammanager.model.equipeMembre;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EquipeMembreId implements Serializable {
    private Integer idEquipe;
    private Integer idMembre;
}
