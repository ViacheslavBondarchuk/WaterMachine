package com.org.house.controller;

import com.org.house.entity.Company;
import com.org.house.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company/add")
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @GetMapping("/company/all")
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @DeleteMapping("/company/delete")
    public void deleteCompany(@RequestParam(value = "id") int id){
        companyService.deleteCompany(id);
    }
}
