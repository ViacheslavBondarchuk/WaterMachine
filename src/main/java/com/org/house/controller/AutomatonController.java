package com.org.house.controller;

import com.org.house.entity.Automaton;
import com.org.house.service.AutomatonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutomatonController {

    @Autowired
    private AutomatonService automatonService;

    @PostMapping("/automatons")
    public Automaton addAutomatic(@RequestBody Automaton automatic){
        return automatonService.addAutomatic(automatic);
    }

    @GetMapping("/automatons")
    public List<Automaton> getAllAutomaton(){
        return automatonService.getAllAutomatic();
    }

    @DeleteMapping("/automatons/{id}")
    public void autmaticDelete(@PathVariable int id){
        automatonService.deleteAutomatic(id);
    }
}
