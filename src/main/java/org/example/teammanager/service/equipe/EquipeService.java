package org.example.teammanager.service.equipe;

import org.example.teammanager.repository.equipe.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public long countAllEquipes() {
        return equipeRepository.count();
    }
}