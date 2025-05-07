package org.example.teammanager.model.membreRoleMembre;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.roleMembre.RoleMembre;

@Data
@Entity
@IdClass(MembreRoleMembreId.class)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "membre_role_membre")
public class MembreRoleMembre {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_membre", referencedColumnName = "id", nullable = false)
    private Membre membre;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_role_membre", referencedColumnName = "id", nullable = false)
    private RoleMembre roleMembre;

}