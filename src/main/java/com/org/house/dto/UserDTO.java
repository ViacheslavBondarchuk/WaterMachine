package com.org.house.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.model.Company;

@Data
public class UserDTO {
    @Null
    private int id;
    @NonNull
    @NotEmpty
    private int age;
    @NotEmpty
    @NotEmpty
    private String firstName;
    @NotEmpty
    @NotEmpty
    private String lastName;
    @NotNull
    private Company company;
}
