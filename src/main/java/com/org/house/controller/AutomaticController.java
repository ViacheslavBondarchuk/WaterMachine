package com.org.house.controller;

import com.org.house.entity.Automatic;
import com.org.house.service.AutomaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutomaticController {

    @Autowired
    private AutomaticService automaticService;

    @PostMapping("/automatic/add")
    public Automatic addAutomatic(@RequestBody Automatic automatic){
        return automaticService.addAutomatic(automatic);
    }

    @GetMapping("/automatic/all")
    public List<Automatic> getAllAutomatic(){
        return automaticService.getAllAutomatic();
    }

    @DeleteMapping("/automatic/delete")
    public void autmaticDelete(@RequestParam(value = "id") int id){
        automaticService.deleteAutomatic(id);
    }
}
