package com.org.house.dto;

import com.org.house.entity.Company;

public interface AutomaticDTO {

    public int getId();

    public void setId(int id);

    public String getTradeMark();

    public void setTradeMark(String tradeMark);

    public Company getCompany();

    public void setCompany(Company company);
}
