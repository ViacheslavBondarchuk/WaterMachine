package com.org.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.house.dto.CompanyDTO;
import com.org.house.model.Company;
import com.org.house.service.CompanyService;
import com.org.house.transfer.New;
import com.org.house.transfer.Update;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping
	public Company addCompany(@Validated(New.class) @RequestBody CompanyDTO companyDTO) {
		return companyService.addCompany(companyDTO);
	}

	@GetMapping
	public List<Company> getAllCompany() {
		return companyService.getAllCompany();
	}

	@PutMapping
	public Company updateCompany(@Validated(Update.class) @RequestBody CompanyDTO companyDTO) {
		return companyService.updateCompany(companyDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyService.deleteCompany(id);
	}
}
