package com.org.house.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.sql.Update;

import com.org.house.transfer.New;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomatonDTO {
	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private int id;
	@NotBlank(groups = { New.class, Update.class })
	private String tradeMark;

}
