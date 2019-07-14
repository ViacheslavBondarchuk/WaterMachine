package com.org.house.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.house.dto.CompanyDTO;
import com.org.house.model.Company;
import com.org.house.repository.CompanyRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company addCompany(CompanyDTO companyDTO) {
		return companyRepository.save(new ModelMapper().map(companyDTO, Company.class));
	}

	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}

	public void deleteCompany(long id) {
		companyRepository.deleteById(id);
	}

	public Company updateCompany(CompanyDTO companyDTO) {
		return companyRepository.save(new ModelMapper().map(companyDTO, Company.class));
	}

}
