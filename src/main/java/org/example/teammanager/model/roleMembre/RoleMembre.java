package org.example.teammanager.model.roleMembre;

import jakarta.persistence.*;

@Entity
@Table(name = "role_membre") // Make sure table name matches your DB
public class RoleMembre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomRole;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomRole() {
        return nomRole;
    }
    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }
}