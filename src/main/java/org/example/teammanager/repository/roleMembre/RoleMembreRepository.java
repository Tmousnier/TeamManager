package org.example.teammanager.repository.roleMembre;

import org.example.teammanager.model.roleMembre.RoleMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Importez Optional

@Repository
public interface RoleMembreRepository extends JpaRepository<RoleMembre, Integer> { // Utilisez Integer comme type de clé primaire
    Optional<RoleMembre> findByNomRole(String nomRole); // Méthode complète
}