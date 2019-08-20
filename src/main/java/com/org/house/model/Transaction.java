package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "automaton_id")
    private int automatonId;

    @Column(name = "copmany_id")
    private long companyId;

    @Column(name = "cost")
    private double cost;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "quantity_water")
    private double quantityWater;

    @Column(name = "per_card")
    private boolean byCard;
    
    @Column(name = "transaction_type")
    private TransactionType type;
}
