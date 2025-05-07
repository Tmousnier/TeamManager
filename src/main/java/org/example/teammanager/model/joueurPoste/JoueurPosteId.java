package org.example.teammanager.model.joueurPoste;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class JoueurPosteId implements Serializable {
    private Integer idJoueur;
    private Integer idPoste;
}