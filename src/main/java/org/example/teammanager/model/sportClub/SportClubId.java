package org.example.teammanager.model.sportClub;

import lombok.Data;
import java.io.Serializable;

@Data
public class SportClubId implements Serializable {

    private Integer sport;  // Must match the type of the Sport ID
    private Integer club;   // Must match the type of the Club ID

}