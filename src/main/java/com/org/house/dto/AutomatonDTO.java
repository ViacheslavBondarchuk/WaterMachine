package com.org.house.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.sql.Update;

import com.org.house.transfer.NewUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomatonDTO {
    @Null(groups = {NewUser.class})
    @NotNull(groups = {Update.class})
    private int id;
    @NotBlank(groups = {NewUser.class, Update.class})
    private String tradeMark;
    @NotBlank(groups = {NewUser.class, Update.class})
    private long company_id;


}
