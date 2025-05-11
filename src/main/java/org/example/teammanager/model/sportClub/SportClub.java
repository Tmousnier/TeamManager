package org.example.teammanager.model.sportClub;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.membreMessage.MembreMessageId;
import org.example.teammanager.model.sport.Sport;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sport_club")
public class SportClub {

    @EmbeddedId
    private SportClubId id;

    @ManyToOne
    @MapsId("idClub")
    @JoinColumn(name = "id_club")
    private Club club;

    @ManyToOne
    @MapsId("idSport")
    @JoinColumn(name = "id_sport")
    private Sport sport;

}
