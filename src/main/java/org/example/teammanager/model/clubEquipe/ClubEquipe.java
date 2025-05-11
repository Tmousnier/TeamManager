package org.example.teammanager.model.clubEquipe;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.equipe.Equipe;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "club_equipe")

public class ClubEquipe {
    @EmbeddedId
    private ClubEquipeId id;

    @ManyToOne
    @MapsId("idClub")
    @JoinColumn(name = "id_club")
    private Club club;

    @ManyToOne
    @MapsId("idEquipe")
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;
}
