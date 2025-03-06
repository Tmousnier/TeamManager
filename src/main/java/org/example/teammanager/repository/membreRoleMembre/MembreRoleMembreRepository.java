// MembreRoleMembreRepository.java
package org.example.teammanager.repository.membreRoleMembre;

import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRoleMembreRepository extends JpaRepository<MembreRoleMembre, Integer> {
    List<MembreRoleMembre> findByIdRoleMembreId(int idRoleMembre); // Find by RoleMembre ID
    List<MembreRoleMembre> findByIdMembreId(int idMembre); // Find by Membre ID
}