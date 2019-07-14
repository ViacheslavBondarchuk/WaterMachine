package com.org.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.house.model.Company;
import com.org.house.repository.CompanyRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company addCompany(Company company) {

		log.info("company was added");
		return companyRepository.save(company);
	}

	public List<Company> getAllCompany() {

		log.info("company was gotten");
		return companyRepository.findAll();
	}

	public void deleteCompany(long id) {

		log.info("company; " + id + " was deleted");
		companyRepository.deleteById(id);
	}

	public Company updateCompany(Company company) {
		log.info("Company: " + company.getId() + " was updated");
		companyRepository.findById(company.getId()).ifPresent(company1 -> company.setId(company1.getId()));

		return companyRepository.saveAndFlush(company);
	}

}
