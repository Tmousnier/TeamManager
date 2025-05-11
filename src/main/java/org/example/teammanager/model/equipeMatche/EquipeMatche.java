package org.example.teammanager.model.equipeMatche;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.matche.Matche;

@Entity
@Table(name = "equipe_matche")
@Data
@NoArgsConstructor
public class EquipeMatche {
    @EmbeddedId
    private EquipeMatcheId id;

    @ManyToOne
    @MapsId("idEquipe")
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    @ManyToOne
    @MapsId("idMatche")
    @JoinColumn(name = "id_matche")
    private Matche matche;
}
