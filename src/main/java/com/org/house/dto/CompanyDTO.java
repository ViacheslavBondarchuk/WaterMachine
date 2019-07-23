package com.org.house.dto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.model.Automaton;
import com.org.house.model.User;
import com.org.house.transfer.NewUser;
import com.org.house.transfer.UpdateUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {

    @Null(groups = {NewUser.class})
    @NotNull(groups = {UpdateUser.class})
    private long id;

    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private String name;
    @NotBlank(groups = {NewUser.class, UpdateUser.class})
    private long owner_id;

    @Valid
    private Set<User> users;
    @Valid
    private Set<Automaton> automatics;

}
