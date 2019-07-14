package com.org.house.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "account_id")
	private int accountId;
	@Column(name = "automatic_id")
	private int automaticId;
	private double cost;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "quantity_water")
	private double quantityWater;
	@Column(name = "get_money")
	private boolean getMoney;
}
