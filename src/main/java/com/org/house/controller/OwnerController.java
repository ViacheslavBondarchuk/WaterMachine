package com.org.house.controller;

import com.org.house.dto.OwnerDTO;
import com.org.house.model.Owner;
import com.org.house.service.OwnerService;
import com.org.house.transfer.UpdateOwner;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PatchMapping
    public void updateOwner(@Validated(UpdateOwner.class) @RequestBody OwnerDTO ownerDTO) {
        ownerService.updateOwner(ownerDTO);
    }

    @GetMapping
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwner();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable long id) throws NotFoundException {
        return ownerService.getOwnerById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        ownerService.deleteById(id);
    }

}
