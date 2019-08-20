package com.org.house.dto;

import com.org.house.model.Authority;
import com.org.house.model.Master;
import com.org.house.model.Owner;
import com.org.house.transfer.NewUser;
import com.org.house.transfer.UpdateMaster;
import com.org.house.transfer.UpdateUser;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
public class UserDTO {
    @Null(groups = NewUser.class)
    @NotNull(groups = UpdateMaster.class)
    private long id;

    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private String email;

    @Null(groups = NewUser.class)
    @NotNull(groups = UpdateUser.class)
    private long companyId;

    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private String username;

    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private String password;

    @Null(groups = {NewUser.class, UpdateUser.class})
    private boolean isMaster;
    @Null(groups = {NewUser.class, UpdateUser.class})
    private boolean isOwner;

    @Null(groups = NewUser.class)
    @NotNull(groups = UpdateUser.class)
    private boolean isEnabled;

    @Null(groups = NewUser.class)
    @NotNull(groups = UpdateUser.class)
    private boolean isAccountNonLocked;

    @Null(groups = NewUser.class)
    @NotNull(groups = UpdateUser.class)
    private boolean isAccountNonExpired;

    @Null(groups = NewUser.class)
    @NotNull(groups = UpdateUser.class)
    private boolean isCredentialsNonExpired;


    private Set<Authority> authorities;
    private Owner owners;
    private Master masters;
}
