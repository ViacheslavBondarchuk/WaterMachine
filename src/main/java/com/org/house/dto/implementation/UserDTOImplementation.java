package com.org.house.dto.implementation;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.inspiresoftware.lib.dto.geda.annotations.DtoParent;
import com.org.house.dto.UserDTO;
import com.org.house.entity.Company;

@Dto
public class UserDTOImplementation implements UserDTO {
    @DtoField
    private int id;
    @DtoField
    private int age;
    @DtoField
    private String firstName;
    @DtoField
    private String lastName;
    @DtoParent
    private Company company;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void setAge(int age) {

    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public Company getCompany() {
        return null;
    }

    @Override
    public void setCompany(Company company) {

    }
}
