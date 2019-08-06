package com.org.house.dto;

import com.org.house.transfer.NewMaster;
import com.org.house.transfer.UpdateMaster;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
public class MasterDTO {

    @NotBlank(groups = {NewMaster.class,UpdateMaster.class})
    private long id;
    @NotBlank(groups = {NewMaster.class, UpdateMaster.class})
    private long companyId;
    @NotBlank(groups = {NewMaster.class, UpdateMaster.class})
    private String firstName;
    @NotBlank(groups = {NewMaster.class, UpdateMaster.class})
    private String lastName;


}
