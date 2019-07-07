package com.org.house.service;

import com.org.house.entity.Automaton;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import com.org.house.repository.AutomatonRepository;

@Log4j2
@Service
public class AutomatonService {

    @Autowired
    private AutomatonRepository automaticRepository;

    public Automaton addAutomatic(Automaton automatic) {
        log.info("automatic was added");
        return automaticRepository.save(automatic);
    }

    public List<Automaton> getAllAutomatic() {
        log.info("automatic was gotten");
        return automaticRepository.findAll();
    }

    public void deleteAutomatic(int id) {
        log.info("automatic " + id + " was deleted");
        automaticRepository.deleteById(id);
    }
}
