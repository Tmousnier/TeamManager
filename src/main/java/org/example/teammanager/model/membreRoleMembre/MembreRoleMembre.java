package org.example.teammanager.model.membreRoleMembre;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.roleMembre.RoleMembre;

@Getter
@Entity
@Table(name = "membre_role_membre")
@IdClass(MembreRoleMembreId.class)
public class MembreRoleMembre {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_membre", referencedColumnName = "id")
    private Membre idMembre;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_role_membre", referencedColumnName = "id")
    private RoleMembre idRoleMembre;

    public MembreRoleMembre() {}  // No-args constructor (important for JPA)

    public void setIdMembre(Membre idMembre) {
        this.idMembre = idMembre;
    }

    public void setIdRoleMembre(RoleMembre idRoleMembre) {
        this.idRoleMembre = idRoleMembre;
    }
}