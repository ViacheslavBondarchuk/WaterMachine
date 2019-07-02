package com.org.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.util.Date;

@Data
@Log4j2
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long accId;
    private double cost;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double quantity;
    private String waterName;
    private String automaticName;

    public static class TransactionBuilder {

        private Transaction transaction;

        public TransactionBuilder() {
            transaction = new Transaction();
        }

        public TransactionBuilder accId(long accId) {
            transaction.accId = accId;
            return this;
        }

        public TransactionBuilder cost(double cost) {
            transaction.cost = cost;
            return this;
        }

        public TransactionBuilder date(Date date) {
            transaction.date = date;
            return this;
        }

        public TransactionBuilder quantity(double quantity) {
            transaction.quantity = quantity;
            return this;
        }

        public TransactionBuilder waterName(String waterName) {
            transaction.waterName = waterName;
            return this;
        }

        public TransactionBuilder automaticName(String automaticName) {
            transaction.automaticName = automaticName;
            return this;
        }

        public Transaction build() {
            return transaction;
        }
    }
}
