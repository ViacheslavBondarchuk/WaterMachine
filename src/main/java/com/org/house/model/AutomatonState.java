package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Builder;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutomatonState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quantity_money")
    private double money;
    @Column(name = "quantity_water")
    private double water;
    @Column(name = "automaton_id")
    private long automatonId;

}
