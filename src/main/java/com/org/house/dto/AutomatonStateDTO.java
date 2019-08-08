package com.org.house.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.transfer.NewMaster;
import com.org.house.transfer.NewUser;
import com.org.house.transfer.UpdateMaster;
import com.org.house.transfer.UpdateUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomatonStateDTO {
    @Null(groups = {NewUser.class})
    @NotNull(groups = {UpdateUser.class})
    private long id;

    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private double money;

    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private double water;

    @NotNull(groups = {NewUser.class})
    @Null(groups = {UpdateUser.class})
    private long automatonId;

    @NotBlank(groups = {NewMaster.class, UpdateMaster.class})
    private String username;
}
