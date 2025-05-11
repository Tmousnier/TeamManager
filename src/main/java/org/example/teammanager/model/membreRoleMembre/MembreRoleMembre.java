package org.example.teammanager.model.membreRoleMembre;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.roleMembre.RoleMembre;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "membre_role_membre")
public class MembreRoleMembre {

    @EmbeddedId
    private MembreRoleMembreId id;

    @ManyToOne
    @MapsId("idMembre")
    @JoinColumn(name = "id_membre")
    private Membre membre;

    @ManyToOne
    @MapsId("idRoleMembre")
    @JoinColumn(name = "id_role_membre")
    private RoleMembre roleMembre;

}