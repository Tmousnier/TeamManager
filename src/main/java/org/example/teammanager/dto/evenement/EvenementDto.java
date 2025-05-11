package org.example.teammanager.dto.evenement;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EvenementDto {
    private Long id;
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String lieux;
}