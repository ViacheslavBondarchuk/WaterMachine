package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutomatonState {
    @Id
    @Column(name = "automaton_id")
    private long automatonId;
    @Column(name = "quantity_money")
    private double money;
    @Column(name = "quantity_water")
    private double water;


}
