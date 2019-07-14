package com.org.house.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.model.Company;

@Data
public class AutomatonDTO {
	@Null
	private int id;
	@NotBlank
	private String tradeMark;
	@NotNull
	private Company company;

}
