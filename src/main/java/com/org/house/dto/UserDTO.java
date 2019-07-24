package com.org.house.dto;

import com.org.house.model.Authority;
import com.org.house.transfer.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
public class UserDTO {
    @Null(groups = {NewUser.class, NewOwner.class, NewMaster.class})
    @NotNull(groups = {UpdateUser.class, UpdateOwner.class, UpdateMaster.class})
    private long id;
    @NotBlank(groups = {NewUser.class, NewOwner.class, NewMaster.class
            , UpdateUser.class, UpdateMaster.class, UpdateOwner.class})
    private String username;
    @NotBlank(groups = {NewUser.class, NewOwner.class, NewMaster.class
            , UpdateUser.class, UpdateMaster.class, UpdateOwner.class})
    private String email;
    @NotBlank(groups = {NewUser.class, NewOwner.class, NewMaster.class
            , UpdateUser.class, UpdateMaster.class, UpdateOwner.class})
    private String password;
    @NotBlank(groups = {NewUser.class, NewOwner.class, NewMaster.class
            , UpdateUser.class, UpdateMaster.class, UpdateOwner.class})
    private int company_id;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private long master_id;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private boolean isOwner;
    @NotBlank(groups = {NewMaster.class, UpdateMaster.class})
    private boolean isMaster;
    @Null(groups = {NewUser.class, NewOwner.class, NewMaster.class})
    @NotNull(groups = {UpdateUser.class, UpdateOwner.class, UpdateMaster.class})
    private boolean isEnabled;
    @Null(groups = {NewUser.class, NewOwner.class, NewMaster.class})
    @NotNull(groups = {UpdateUser.class, UpdateOwner.class, UpdateMaster.class})
    private boolean isAccountNonLocked;
    @Null(groups = {NewUser.class, NewOwner.class, NewMaster.class})
    @NotNull(groups = {UpdateUser.class, UpdateOwner.class, UpdateMaster.class})
    private boolean isAccountNonExpired;
    @Null(groups = {NewUser.class, NewOwner.class, NewMaster.class})
    @NotNull(groups = {UpdateUser.class, UpdateOwner.class, UpdateMaster.class})
    private boolean isCredentialsNonExpired;

    private Set<Authority> authorities;
}
