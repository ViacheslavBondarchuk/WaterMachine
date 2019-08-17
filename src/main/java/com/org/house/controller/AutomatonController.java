package com.org.house.controller;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.service.AutomatonService;
import com.org.house.transfer.NewAutomaton;
import com.org.house.transfer.UpdateAutomaton;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automatons")
public class AutomatonController {

    @Autowired
    private AutomatonService automatonService;

    @PostMapping
    public void addAutomaton(@Validated(NewAutomaton.class) @RequestBody AutomatonDTO automatonDTO) {
        automatonService.addAutomaton(automatonDTO);
    }

    @GetMapping("/masters/{id}")
    public List<Automaton> getMasterAutomaton(@PathVariable long id) {
        return automatonService.getMasterAutomaton(id);
    }

    @GetMapping
    public List<Automaton> getAllAutomatons() {
        return automatonService.getAllAutomaton();
    }

    @GetMapping("/{id}")
    public Automaton getOneAutomaton(@PathVariable long id) {
        return automatonService.getOneAutomaton(id);
    }


    @PatchMapping
    public void updateAutomatoonById(@Validated(UpdateAutomaton.class) @RequestBody AutomatonDTO automaton)
            throws NotFoundException {
        automatonService.updateAutomaton(automaton);

    }

    @DeleteMapping("/{id}")
    public void autmatonDelete(@PathVariable int id) {
        automatonService.deleteAutomaton(id);
    }
}
