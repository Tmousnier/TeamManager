package org.example.teammanager.model.membreRoleMembre;

import java.io.Serializable;
import java.util.Objects;

public class MembreRoleMembreId implements Serializable {

    private Integer idMembre; // Should match the ID type of Membre
    private Integer idRoleMembre; // Should match the ID type of RoleMembre

    public MembreRoleMembreId() {} // Required for JPA

    public MembreRoleMembreId(Integer idMembre, Integer idRoleMembre) { // Corrected constructor
        this.idMembre = idMembre;
        this.idRoleMembre = idRoleMembre;
    }

    @Override
    public boolean equals(Object o) { // Corrected equals
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembreRoleMembreId that = (MembreRoleMembreId) o;
        return Objects.equals(idMembre, that.idMembre) && Objects.equals(idRoleMembre, that.idRoleMembre);
    }

    @Override
    public int hashCode() { // Corrected hashCode
        return Objects.hash(idMembre, idRoleMembre);
    }

}