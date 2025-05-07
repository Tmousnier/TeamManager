package org.example.teammanager.mapper;

import org.example.teammanager.dto.club.ClubInscriptionDTO;
import org.example.teammanager.model.club.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ville", ignore = true)
    @Mapping(target = "addresse", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "pays", ignore = true)
    @Mapping(target = "numeroTelephone", ignore = true)
    @Mapping(target = "nom", source = "nomClub") // Mappage de nomClub à nom
    Club inscribe(ClubInscriptionDTO clubInscriptionDTO);
}
