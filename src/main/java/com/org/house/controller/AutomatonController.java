package com.org.house.controller;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.service.AutomatonService;
import com.org.house.transfer.NewAutomaton;
import com.org.house.transfer.UpdateAutomaton;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Secured("ADMIN")
@RestController
@RequestMapping("/automatons")
public class AutomatonController {

    @Autowired
    private AutomatonService automatonService;

    @PostMapping
    public Automaton addAutomaton(@Validated(NewAutomaton.class) @RequestBody AutomatonDTO automatonDTO) {
        return automatonService.addAutomaton(automatonDTO);
    }

    @GetMapping
    public List<Automaton> getAllAutomatons() {
        return automatonService.getAllAutomaton();
    }

    @GetMapping("/{id}")
    public Automaton getOneAutomaton(@PathVariable long id) throws NotFoundException {
        return automatonService.getOneAutomaton(id);
    }

    @PatchMapping
    public void updateAutomatoonById(@Validated(UpdateAutomaton.class) @RequestBody AutomatonDTO automaton)
            throws NotFoundException {
        automatonService.updateAutomaton(automaton);

    }

    @DeleteMapping("/{id}")
    public void autmatonDelete(@PathVariable int id) throws NotFoundException {
        automatonService.deleteAutomaton(id);
    }
}
