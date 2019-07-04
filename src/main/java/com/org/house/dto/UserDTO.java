package com.org.house.dto;

import com.org.house.entity.Company;

public interface UserDTO {

    public int getId();

    public void setId(int id);

    public int getAge();

    public void setAge(int age);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public Company getCompany();

    public void setCompany(Company company);
}
