package com.org.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AutomaticState implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity_money")
    private double money;
    @Column(name = "quantity_water")
    private double water;
    @Column(name = "automatic_id")
    private int automaticId;


    public static class BuilderAutomaticState {
        private AutomaticState automaticState;

        public BuilderAutomaticState() {
            automaticState = new AutomaticState();
        }

        public BuilderAutomaticState money(double money) {
            automaticState.money = money;
            return this;
        }

        public BuilderAutomaticState water(double water) {
            automaticState.water = water;
            return this;
        }

        public BuilderAutomaticState automaticId(int automaticId) {
            automaticState.automaticId = automaticId;
            return this;
        }

        public AutomaticState build() {
            return automaticState;
        }

    }
}
