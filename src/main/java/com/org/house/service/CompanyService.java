package com.org.house.service;

import com.org.house.entity.Company;
import com.org.house.repository.CompanyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company) {

        log.info("company was added");
        return companyRepository.save(company);
    }

    public List<Company> getAllCompany(){

        log.info("company was gotten");
        return companyRepository.findAll();
    }

    public void deleteCompany(int id){

        log.info("company; " + id + " was deleted");
        companyRepository.deleteById(id);
    }
}
