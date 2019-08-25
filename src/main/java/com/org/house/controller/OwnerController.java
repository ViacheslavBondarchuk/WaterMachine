package com.org.house.controller;

import com.org.house.dto.UserOwnerDTO;
import com.org.house.model.Owner;
import com.org.house.service.OwnerService;
import com.org.house.transfer.NewOwner;
import com.org.house.transfer.UpdateMaster;
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

    @PostMapping
    public void addOwner(@Validated(NewOwner.class) @RequestBody UserOwnerDTO userOwnerDTO){
        ownerService.addOwner(userOwnerDTO);
    }

    @PatchMapping
    public void updateOwner(@Validated(UpdateOwner.class) @RequestBody UserOwnerDTO userOwnerDTO) {
        ownerService.updateOwner(userOwnerDTO);
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
