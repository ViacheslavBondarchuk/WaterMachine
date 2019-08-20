package com.org.house.dto;

import com.org.house.model.Authority;
import com.org.house.model.Master;
import com.org.house.model.Owner;
import com.org.house.transfer.NewOwner;
import com.org.house.transfer.UpdateOwner;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
public class OwnerDTO {
    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private long id;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String email;

    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private long companyId;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String username;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String password;

    @Null(groups = {NewOwner.class,UpdateOwner.class})
    private boolean isMaster;

    @NotNull(groups = {NewOwner.class, UpdateOwner.class})
    private boolean isOwner;

    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private boolean isEnabled;

    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private boolean isAccountNonLocked;

    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private boolean isAccountNonExpired;

    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private boolean isCredentialsNonExpired;



    private Set<Authority> authorities;
    private Owner owners;
    private Master masters;
}
