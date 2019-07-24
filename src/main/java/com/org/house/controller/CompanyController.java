package com.org.house.controller;

import java.util.List;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.org.house.dto.CompanyDTO;
import com.org.house.model.Company;
import com.org.house.service.CompanyService;
import com.org.house.transfer.NewUser;
import com.org.house.transfer.UpdateUser;

@Secured("ADMIN")
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company addCompany(@Validated(NewUser.class) @RequestBody CompanyDTO companyDTO) {
        return companyService.addCompany(companyDTO);
    }

    @GetMapping
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    public Company getOneCompany(@PathVariable long id) throws NotFoundException {
        return companyService.getOneCompany(id);
    }

    @Secured("OWNER")
    @PatchMapping
    public void updateCompany(@Validated(UpdateUser.class) @RequestBody CompanyDTO companyDTO) {
//        companyService.updateCompany(companyDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
    }
}
