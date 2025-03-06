package org.example.teammanager.service.membreRoleMembre;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.repository.membreRoleMembre.MembreRoleMembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; // Utiliser List ici, car il peut y avoir plusieurs MembreRoleMembre pour un membre

@Service
public class MembreRoleMembreService {

    @Autowired
    private MembreRoleMembreRepository membreRoleMembreRepository;

    public List<MembreRoleMembre> findByIdMembre(Membre membre) {
        return membreRoleMembreRepository.findByIdMembreId(membre.getId());
    }

    // ... other MembreRoleMembre related service methods
}