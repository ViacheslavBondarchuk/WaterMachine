package com.org.house.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.transfer.New;
import com.org.house.transfer.Update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomatonStateDTO {
	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private long id;
	@NotBlank(groups = { New.class, Update.class })
	private double money;
	@NotBlank(groups = { New.class, Update.class })
	private double water;
	@NotNull(groups = { New.class })
	@Null(groups = { Update.class })
	private long automatonId;
}
