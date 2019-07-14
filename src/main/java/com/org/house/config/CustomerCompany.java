package com.org.house.security;

import com.org.house.entity.Company;
import org.springframework.security.core.userdetails.User;

public class CustomerCompany extends User {
    private static final long serialVersionUID = 1L;
    
    public CustomerCompany(Company company) {
        super(company.getEmail(), company.getPassword(), company.getGrantedAuthoritiesList());
    }
}
