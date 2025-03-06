package org.example.teammanager.mapper;

import org.example.teammanager.dto.club.ClubInscriptionDTO;
import org.example.teammanager.model.club.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    Club toClub(ClubInscriptionDTO clubInscriptionDTO);
}
