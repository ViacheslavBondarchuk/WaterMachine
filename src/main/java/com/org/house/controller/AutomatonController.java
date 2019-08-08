package com.org.house.controller;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.model.Master;
import com.org.house.model.QMaster;
import com.org.house.security.SecurityInformation;
import com.org.house.service.AutomatonService;
import com.org.house.transfer.NewAutomaton;
import com.org.house.transfer.UpdateAutomaton;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@Secured("ADMIN,MASTER")
@RequestMapping("/automatons")
public class AutomatonController {

    @Autowired
    private AutomatonService automatonService;

    @PostMapping
    public void addAutomaton(@Validated(NewAutomaton.class) @RequestBody AutomatonDTO automatonDTO) {
        automatonService.addAutomaton(automatonDTO);
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
