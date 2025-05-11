package org.example.teammanager.service.membreRoleMembre;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.repository.membreRoleMembre.MembreRoleMembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreRoleMembreService {

    @Autowired
    private MembreRoleMembreRepository membreRoleMembreRepository;


    public List<MembreRoleMembre> findByMembreId(Membre membre) {
        return membreRoleMembreRepository.findByMembre_IdMembre(membre.getIdMembre());
    }
}


