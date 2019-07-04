package com.org.house.dto.implementation;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.org.house.dto.TransactionDTO;

import java.util.Date;

@Dto
public class TransactionDTOImplementation implements TransactionDTO {
    @DtoField
    private int id;
    @DtoField
    private int accountId;
    @DtoField
    private int automaticId;
    @DtoField
    private double cost;
    @DtoField
    private Date date;
    @DtoField
    private double quantityWater;
    @DtoField
    private boolean getMoney;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getAccountId() {
        return 0;
    }

    @Override
    public void setAccountId(int accountId) {

    }

    @Override
    public int getAutomaticId() {
        return 0;
    }

    @Override
    public void setAutomaticId(int automaticId) {

    }

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public void setCost(double cost) {

    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public void setDate(Date date) {

    }

    @Override
    public double getQuantityWater() {
        return 0;
    }

    @Override
    public void setQuantityWater(double quantityWater) {

    }

    @Override
    public boolean isGetMoney() {
        return false;
    }

    @Override
    public void setGetMoney(boolean getMoney) {

    }
}
