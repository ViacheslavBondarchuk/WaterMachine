package com.org.house.dto;

import com.org.house.transfer.New;
import com.org.house.transfer.Update;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Getter
@Setter
public class TransactionDTO {

    @Null(groups = {New.class})
    private long id;
    @NotBlank(groups = {New.class, Update.class})
    private long accountId;
    @NotBlank(groups = {New.class, Update.class})
    private long automaticId;
    @NotBlank(groups = {New.class, Update.class})
    private long companyId;
    @NotBlank(groups = {New.class, Update.class})
    private double cost;
    @Null(groups = {New.class, Update.class})
    private Date date;
    @NotBlank(groups = {New.class, Update.class})
    private double quantityWater;
    @NotBlank(groups = {New.class, Update.class})
    private boolean getMoney;

}
