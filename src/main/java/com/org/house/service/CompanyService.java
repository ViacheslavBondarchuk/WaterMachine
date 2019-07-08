package com.org.house.service;

import com.org.house.entity.Company;
import com.org.house.repository.CompanyRepository;
import com.org.house.security.CustomerCompany;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class CompanyService implements UserDetailsService {

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

    public Company updateCompany(Company company){
        log.info("Company: " + company.getId() + " was updated");
         companyRepository.findById(company.getId()).ifPresent(company1 -> company.setId(company1.getId()));

         return companyRepository.saveAndFlush(company);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Company company = null;
        try{
            company = companyRepository.findByEmail(email);
            CustomerCompany customerUser = new CustomerCompany(company);
            return customerUser;
        }catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException("Email: " + email + " was not found in the database");
        }
    }
}
