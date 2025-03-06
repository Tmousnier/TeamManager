package org.example.teammanager.repository.equipeMembre;

import org.example.teammanager.model.equipeMembre.EquipeMembre;
import org.example.teammanager.model.equipeMembre.EquipeMembreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeMembreRepository extends JpaRepository<EquipeMembre, EquipeMembreId> {
}
