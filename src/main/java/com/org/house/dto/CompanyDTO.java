package com.org.house.dto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.model.Automaton;
import com.org.house.model.User;
import com.org.house.transfer.New;
import com.org.house.transfer.Update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {

	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private long id;

	@NotBlank(groups = { New.class, Update.class })
	private String name;

	@Valid
	private Set<User> users;
	@Valid
	private Set<Automaton> automatics;

}
