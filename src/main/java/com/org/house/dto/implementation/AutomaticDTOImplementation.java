package com.org.house.dto.implementation;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.inspiresoftware.lib.dto.geda.annotations.DtoParent;
import com.org.house.dto.AutomaticDTO;
import com.org.house.entity.Company;

@Dto
public class AutomaticDTOImplementation implements AutomaticDTO {
    @DtoField
    private int id;
    @DtoField
    private String tradeMark;
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
    public String getTradeMark() {
        return null;
    }

    @Override
    public void setTradeMark(String tradeMark) {

    }

    @Override
    public Company getCompany() {
        return null;
    }

    @Override
    public void setCompany(Company company) {

    }
}
