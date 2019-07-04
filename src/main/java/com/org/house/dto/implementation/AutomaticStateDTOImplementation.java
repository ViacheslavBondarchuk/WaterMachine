package com.org.house.dto.implementation;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.org.house.dto.AutomaticDTO;
import com.org.house.entity.Company;

@Dto
public class AutomaticStateDTOImplementation implements AutomaticDTO {
    @DtoField
    private int id;
    @DtoField
    private double money;
    @DtoField
    private double water;
    @DtoField
    private int automaticId;

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
