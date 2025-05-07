package org.example.teammanager.model.equipeMatche;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.matche.Matche;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "equipe_matche")
public class EquipeMatche {
    @EmbeddedId
    private EquipeMatcheId id;

    @ManyToOne
    @MapsId("idEquipe")
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;

    @ManyToOne
    @MapsId("idMatche")
    @JoinColumn(name = "id_matche", referencedColumnName = "id")
    private Matche matche;

}

