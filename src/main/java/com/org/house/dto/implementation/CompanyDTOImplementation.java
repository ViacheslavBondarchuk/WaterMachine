package com.org.house.dto.implementation;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoCollection;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.inspiresoftware.lib.dto.geda.annotations.DtoParent;
import com.org.house.dto.CompanyDTO;
import com.org.house.entity.Automatic;
import com.org.house.entity.User;

import java.util.Set;

@Dto
public class CompanyDTOImplementation implements CompanyDTO {
    @DtoField
    private int id;
    @DtoField
    private String name;
    @DtoField
    private String email;
    @DtoField
    private String password;
    @DtoCollection
    private Set<Automatic> automatics;
    @DtoParent
    private User user;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public Set<Automatic> getAutomatics() {
        return null;
    }

    @Override
    public void setAutomatics(Set<Automatic> automatics) {

    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void setUser(User user) {

    }
}
