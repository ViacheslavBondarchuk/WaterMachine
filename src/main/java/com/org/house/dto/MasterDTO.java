package com.org.house.dto;

import com.org.house.model.Authority;
import com.org.house.model.Master;
import com.org.house.model.Owner;
import com.org.house.transfer.NewMaster;
import com.org.house.transfer.UpdateMaster;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
public class MasterDTO {
    @Null(groups = NewMaster.class)
    @NotNull(groups = UpdateMaster.class)
    private long id;

    @NotBlank(groups ={NewMaster.class, UpdateMaster.class})
    private String email;

    @Null(groups = NewMaster.class)
    @NotNull(groups = UpdateMaster.class)
    private long companyId;

    @NotBlank(groups ={NewMaster.class, UpdateMaster.class})
    private String username;

    @NotBlank(groups ={NewMaster.class, UpdateMaster.class})
    private String password;

    @NotNull(groups ={NewMaster.class, UpdateMaster.class})
    private boolean isMaster;

    @Null(groups ={NewMaster.class, UpdateMaster.class})
    private boolean isOwner;

    @Null(groups = NewMaster.class)
    @NotNull(groups = UpdateMaster.class)
    private boolean isEnabled;

    @Null(groups = NewMaster.class)
    @NotNull(groups = UpdateMaster.class)
    private boolean isAccountNonLocked;

    @Null(groups = NewMaster.class)
    @NotNull(groups = UpdateMaster.class)
    private boolean isAccountNonExpired;

    @Null(groups = NewMaster.class)
    @NotNull(groups = UpdateMaster.class)
    private boolean isCredentialsNonExpired;



    private Set<Authority> authorities;
    private Owner owners;
    private Master masters;
}
