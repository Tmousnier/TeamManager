package org.example.teammanager.dto.sport;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class SportDTO {
    @Id
    private int id;
    private String nom;
    private int nombreClubs;

    public SportDTO(){}
}