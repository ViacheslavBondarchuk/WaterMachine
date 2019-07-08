package com.org.house.service;

import com.org.house.entity.Automaton;
import com.org.house.repository.AutomatonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class AutomatonService {

    @Autowired
    private AutomatonRepository automatonRepository;

    public Automaton addAutomatic(Automaton automatic) {
        log.info("automatic was added");
        return automatonRepository.save(automatic);
    }

    public List<Automaton> getAllAutomatic() {
        log.info("automatic was gotten");
        return automatonRepository.findAll();
    }

    public void deleteAutomatic(int id) {
        log.info("automatic " + id + " was deleted");
        automatonRepository.deleteById(id);
    }
}
