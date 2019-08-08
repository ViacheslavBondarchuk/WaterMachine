package com.org.house.controller;

import com.org.house.dto.MasterDTO;
import com.org.house.model.Master;
import com.org.house.service.MasterService;
import com.org.house.transfer.UpdateMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/masters")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @PatchMapping
    public void updateMaster(@Validated(UpdateMaster.class) MasterDTO masterDTO) {
        masterService.update(masterDTO);
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
