package com.org.house.controller;

import com.org.house.entity.Transaction;
import com.org.house.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/water-free/{automat}/{water}/{id}/{cost}/{quantity}/add")
    public Transaction addWaterFree(){
       return transactionService.addWater(transaction);
    }

    @PostMapping("/water-paid/{automat}/{water}/{id}/{cost}/{quantity}/add")
    public Transaction addWaterPaid(@PathVariable String automat,
                                    @PathVariable String water,
                                    @PathVariable long id,
                                    @PathVariable double cost,
                                    @PathVariable double quantity){
        return transactionService.addWater(automat, water);
    }
}
