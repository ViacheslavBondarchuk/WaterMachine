package com.org.house;

import com.org.house.entity.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MainApp {


    public static void main(String[] args) {
        System.out.println(new Transaction.TransactionBuilder()
        .accId(1)
        .automaticName("AUTOMAT1")
        .cost(10)
        .date(new Date())
        .quantity(1)
        .waterName("Bonaqua")
        .build());
        SpringApplication.run(MainApp.class, args);
    }

}
