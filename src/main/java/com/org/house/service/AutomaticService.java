package com.org.house.service;

import com.org.house.entity.Automatic;
import com.org.house.repository.AutomaticRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class AutomaticService {

    @Autowired
    private AutomaticRepository automaticRepository;

    public Automatic addAutomatic(Automatic automatic) {
        log.info("automatic was added");
        return automaticRepository.save(automatic);
    }

    public List<Automatic> getAllAutomatic() {
        log.info("automatic was gotten");
        return automaticRepository.findAll();
    }

    public void deleteAutomatic(int id) {
        log.info("automatic " + id + " was deleted");
        automaticRepository.deleteById(id);
    }
}
