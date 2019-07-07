package com.org.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
