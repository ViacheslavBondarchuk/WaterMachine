package com.org.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Builder;

@Data
@Entity
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class AutomatonState implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "quantity_money")
    private double money;
    @Column(name = "quantity_water")
    private double water;
    @Column(name = "automaton_id")
    private int automatonId;

}
