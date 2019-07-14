package com.org.house.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.org.house.transfer.New;
import com.org.house.transfer.Update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {

	@Null(groups = { New.class })
	@NotNull(groups = { Update.class })
	private long id;
	@NotBlank(groups = { New.class, Update.class })
	private int accountId;
	@NotBlank(groups = { New.class, Update.class })
	private int automaticId;
	@NotBlank(groups = { New.class, Update.class })
	private double cost;
	@Null(groups = { New.class, Update.class })
	private Date date;
	@NotBlank(groups = { New.class, Update.class })
	private double quantityWater;
	@NotBlank(groups = { New.class, Update.class })
	private boolean getMoney;

}
