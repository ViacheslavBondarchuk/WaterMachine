package com.org.house.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class AutomaticStateDTO {
    @Null
    private int id;
    @NotNull
    @NotEmpty
    private double money;
    @NotNull
    @NotEmpty
    private double water;
    @NotNull
    @NotEmpty
    private int automaticId;
}
