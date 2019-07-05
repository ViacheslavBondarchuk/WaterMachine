package com.org.house.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class TransactionDTO {
    @Null
    private int id;
    @NotNull
    @NotEmpty
    private int accountId;
    @NotNull
    @NotEmpty
    private int automaticId;
    private double cost;
    @Null
    private Date date;
    @NotNull
    @NotEmpty
    private double quantityWater;
    @NotNull
    @NotEmpty
    private boolean getMoney;

}
