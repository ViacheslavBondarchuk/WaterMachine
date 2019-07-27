package com.org.house.dto;

import com.org.house.model.Company;
import com.org.house.transfer.UpdateOwner;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OwnerDTO {
    @NotBlank(groups = {UpdateOwner.class})
    private long id;
    @NotBlank(groups = {UpdateOwner.class})
    private String firstName;
    @NotBlank(groups = {UpdateOwner.class})
    private String lastName;
    @NotBlank(groups = {UpdateOwner.class})
    private Company companiId;
}
