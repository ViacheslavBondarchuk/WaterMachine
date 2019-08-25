package com.org.house.controller;

import com.org.house.dto.UserMasterDTO;
import com.org.house.model.Master;
import com.org.house.service.MasterService;
import com.org.house.transfer.NewMaster;
import com.org.house.transfer.UpdateMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masters")
public class MasterController {
    @Autowired
    private MasterService masterService;


    @PostMapping
    public void addMaster(@Validated(NewMaster.class) @RequestBody UserMasterDTO userMasterDTO){
        masterService.addMaster(userMasterDTO);
    }

    @PatchMapping
    public void updateMaster(@Validated(UpdateMaster.class) @RequestBody UserMasterDTO userMasterDTO) {
        masterService.update(userMasterDTO);
    }

    @GetMapping("/{id}")
    public Master getMasterById(@PathVariable long id) {
        return masterService.getMasterById(id);
    }

    @GetMapping
    public List<Master> getAllMasterByCompanyId(@RequestParam long id) {
        return masterService.getAllMasterByCompanyId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMasterById(@PathVariable long id) {
        masterService.delete(id);
    }
}
