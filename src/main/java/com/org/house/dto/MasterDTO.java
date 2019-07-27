package com.org.house.dto;

import com.org.house.model.User;
import com.org.house.transfer.UpdateMaster;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class MasterDTO {
    @NotNull(groups = UpdateMaster.class)
    private long companyId;
    @NotNull(groups = UpdateMaster.class)
    private String firstName;
    @NotNull(groups = UpdateMaster.class)
    private String lastName;

    private Set<User> users;
}
