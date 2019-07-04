package com.org.house.dto;

import java.util.Date;

public interface TransactionDTO {

    public int getId();
    public void setId(int id);

    public int getAccountId();

    public void setAccountId(int accountId);

    public int getAutomaticId();

    public void setAutomaticId(int automaticId);

    public double getCost();

    public void setCost(double cost);

    public Date getDate();

    public void setDate(Date date);

    public double getQuantityWater();

    public void setQuantityWater(double quantityWater);

    public boolean isGetMoney();

    public void setGetMoney(boolean getMoney);
}
