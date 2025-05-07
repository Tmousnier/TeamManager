package org.example.teammanager.model.groupeDiscutionMessage;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class GroupeDiscutionMessageId implements Serializable {
    private Integer idGroupeDiscution;
    private Integer idMessage;

}
