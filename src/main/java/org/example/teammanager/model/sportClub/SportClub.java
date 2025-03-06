package org.example.teammanager.model.sportClub;

import jakarta.persistence.*;
import lombok.Data;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.sport.Sport;

@Entity
@Table(name = "sport_club")
@Data
@IdClass(SportClubId.class)
public class SportClub {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_sport", referencedColumnName = "id")
    private Sport sport;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id")
    private Club club;
}
