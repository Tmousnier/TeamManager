package org.example.teammanager.model.responsable;

import jakarta.persistence.*;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.roleResponsable.RoleResponsable;

@Entity
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idMembre")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "idRoleResponsable")
    private RoleResponsable roleResponsable;

    // Getters and Setters
}
