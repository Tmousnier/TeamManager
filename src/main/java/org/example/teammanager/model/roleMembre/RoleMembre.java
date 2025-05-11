package org.example.teammanager.model.roleMembre;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;

import java.util.List;

@Entity
@Table(name = "role_membre")
@Data
@NoArgsConstructor
public class RoleMembre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idRoleMembre;

    @Column(name = "nom_role")
    private String nomRole;

    @OneToMany(mappedBy = "roleMembre")
    private List<MembreRoleMembre> membreRoleMembres;
}