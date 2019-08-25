package com.org.house.dto;

import com.org.house.model.Authority;
import com.org.house.model.Master;
import com.org.house.model.Owner;
import com.org.house.model.UserType;
import com.org.house.transfer.NewOwner;
import com.org.house.transfer.UpdateOwner;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOwnerDTO {
    @Null(groups = NewOwner.class)
    @NotNull(groups = UpdateOwner.class)
    private long id;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String email;

    @NotNull(groups = {NewOwner.class, UpdateOwner.class})
    private long companyId;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String username;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String password;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String firstName;

    @NotBlank(groups = {NewOwner.class, UpdateOwner.class})
    private String lastName;

    @Null(groups = {NewOwner.class, UpdateOwner.class})
    private UserType type;


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
