package org.example.teammanager.model.membreRoleMembre;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MembreRoleMembreId implements Serializable {

    private Integer idMembre; // Correspond à l'ID du membre
    private Integer idRoleMembre; // Correspond à l'ID du rôle de membre
}