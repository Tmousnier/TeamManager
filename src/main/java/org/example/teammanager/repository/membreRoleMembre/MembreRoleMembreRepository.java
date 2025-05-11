package org.example.teammanager.repository.membreRoleMembre;

import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRoleMembreRepository extends JpaRepository<MembreRoleMembre, MembreRoleMembreId> {
    List<MembreRoleMembre> findByMembre_IdMembre(Integer idMembre); // Utilise la relation membre
}