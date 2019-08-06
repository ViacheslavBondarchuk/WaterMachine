package com.org.house.dto;

import com.org.house.model.Company;
import com.org.house.transfer.NewOwner;
import com.org.house.transfer.UpdateOwner;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OwnerDTO {
    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private long id;
    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String firstName;
    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String lastName;
    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private Company companiId;
}
