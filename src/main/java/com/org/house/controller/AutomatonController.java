package com.org.house.controller;

import com.org.house.model.Automaton;
import com.org.house.service.AutomatonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutomatonController {

    @Autowired
    private AutomatonService automatonService;

    @PostMapping("/automatons")
    public Automaton addAutomaton(@RequestBody Automaton automaton) {
        return automatonService.addAutomatic(automaton);
    }

    @GetMapping("/automatons")
    public List<Automaton> getAllAutomaton() {
        return automatonService.getAllAutomatic();
    }

    @PutMapping("/automatons")
    public Automaton updateAutomaton(@RequestBody Automaton automaton) {
        return automatonService.updateAutomaton(automaton);
    }

    @DeleteMapping("/automatons/{id}")
    public void autmaticDelete(@PathVariable int id) {
        automatonService.deleteAutomatic(id);
    }
}
