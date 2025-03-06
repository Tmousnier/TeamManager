package org.example.teammanager.service.equipeMembre;

import org.example.teammanager.model.equipeMembre.EquipeMembre;
import org.example.teammanager.repository.equipeMembre.EquipeMembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeMembreService {

    @Autowired
    private EquipeMembreRepository equipeMembreRepository;

    public List<EquipeMembre> getAllEquipeMembres() {
        return equipeMembreRepository.findAll();
    }
}
