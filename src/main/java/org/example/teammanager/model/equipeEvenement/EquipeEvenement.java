package org.example.teammanager.model.equipeEvenement;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.evenement.Evenement;

@Entity
@Table(name = "equipe_evenement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipeEvenement {
    @EmbeddedId
    private EquipeEvenementId id;

    @ManyToOne
    @MapsId("idEquipe")
    @JoinColumn(name = "id_Equipe", referencedColumnName = "id")
    private Equipe equipe;

    @ManyToOne
    @MapsId("idEvenement")
    @JoinColumn(name = "id_Evenement", referencedColumnName = "id")
    private Evenement evenement;
}