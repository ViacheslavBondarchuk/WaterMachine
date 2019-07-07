package com.org.house.dto;

import com.org.house.entity.Company;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class AutomatonDTO {
    @Null
    private int id;
    @NotNull
    @NotEmpty
    private String tradeMark;
    @NotNull
    private Company company;

}
