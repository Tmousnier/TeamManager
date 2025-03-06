package org.example.teammanager.dto.sportClub;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.teammanager.dto.club.ClubDTO;
import org.example.teammanager.dto.sport.SportDTO;


@Data
@AllArgsConstructor
@Builder
public class SportClubDTO {

    private SportDTO sport;
    private ClubDTO club;


    public SportClubDTO(){}
}