package com.org.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.house.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
