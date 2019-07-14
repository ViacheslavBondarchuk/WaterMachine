package com.org.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.service.AutomatonService;
import com.org.house.transfer.New;
import com.org.house.transfer.Update;

import javassist.NotFoundException;

@RestController
@RequestMapping("/automatons")
public class AutomatonController {

    @Autowired
    private AutomatonService automatonService;

    @PostMapping
    public Automaton addAutomaton(@Validated(New.class) @RequestBody AutomatonDTO automatonDTO) {
        return automatonService.addAutomatic(automatonDTO);
    }

    @GetMapping
    public List<Automaton> getAllAutomatons() {
        return automatonService.getAllAutomatic();
    }

    @PutMapping
    public Automaton updateAutomaton(@Validated(Update.class) @RequestBody AutomatonDTO automatonDTO) {
        return automatonService.updateAutomaton(automatonDTO);
    }
    
    @GetMapping("/{id}")
    public Automaton getOneAutomaton(@PathVariable long id) throws NotFoundException {
    	return automatonService.getOneAutomaton(id);
    }

    @DeleteMapping("/{id}")
    public void autmatonDelete(@PathVariable int id) {
        automatonService.deleteAutomaton(id);
    }
}
