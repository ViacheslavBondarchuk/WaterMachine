package com.org.house.dto;

import com.org.house.entity.Automaton;
import com.org.house.entity.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Data
public class CompanyDTO {
    @Null
    private int id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    private Set<Automaton> automatics;
    @NotNull
    private User user;

}
