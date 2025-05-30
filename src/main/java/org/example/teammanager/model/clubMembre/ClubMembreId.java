package org.example.teammanager.model.clubMembre;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ClubMembreId implements Serializable {
    private Integer idClub;
    private Integer idMembre;
}
