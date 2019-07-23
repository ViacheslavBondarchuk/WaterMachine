package com.org.house.service;

import com.org.house.dto.CompanyDTO;
import com.org.house.model.Company;
import com.org.house.repository.CompanyRepository;
import com.org.house.security.SecurityInformation;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SecurityInformation securityInformation;

    private ModelMapper modelMapper;

    public Company addCompany(CompanyDTO companyDTO) {
        return companyRepository.save(modelMapper.map(companyDTO, Company.class));
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public Company getOneCompany(long id) throws NotFoundException {
        return companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company by " + id + "was not found"));
    }

    public void deleteCompany(long id) {
        companyRepository.deleteById(id);
    }

    public void updateCompany(CompanyDTO companyDTO) throws NotFoundException {
//        Company company = companyRepository.findById(companyDTO.getId())
//                .orElseThrow(() -> new NotFoundException("Company was not found"));
//
//        if (company != null && securityInformation.getUserCompanyId() == companyDTO.getId()) {
//            companyRepository.save(modelMapper.map(companyDTO, Company.class)); Переписати
//        }
    }

}
