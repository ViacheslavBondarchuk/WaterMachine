package com.org.house.dto;

import com.org.house.transfer.NewUser;
import com.org.house.transfer.UpdateUser;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Getter
@Setter
public class TransactionDTO {

    @Null(groups = {NewUser.class})
    private long id;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private long accountId;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private long automaticId;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private long companyId;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private double cost;
    @Null(groups = {NewUser.class, UpdateUser.class})
    private Date date;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private double quantityWater;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private boolean getMoney;

}
