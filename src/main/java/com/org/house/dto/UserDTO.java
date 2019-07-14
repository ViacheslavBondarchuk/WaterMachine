package com.org.house.dto;

import com.org.house.model.Authority;
import com.org.house.transfer.New;
import com.org.house.transfer.Update;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
public class UserDTO {
	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private long id;
	@NotBlank(groups = { New.class, Update.class })
	private String email;
	@NotBlank(groups = { New.class, Update.class })
	private String password;
	@NotBlank(groups = {New.class, Update.class})
	private int company_id;
	@NotBlank(groups = { New.class, Update.class })
	private String username;

	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private boolean isEnabled;
	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private boolean isAccountNonLocked;
	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private boolean isAccountNonExpired;
	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private boolean isCredentialsNonExpired;

	@Valid
	private Set<Authority> authorities;
}
