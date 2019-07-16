package com.org.house.controller;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.service.TransactionService;
import com.org.house.transfer.New;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/water")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Transaction getWater(@Validated(New.class) @RequestBody TransactionDTO transactionDTO) {
        return transactionService.getWater(transactionDTO);
    }

    @PostMapping
    public Transaction addWater(@Validated(New.class) @RequestBody TransactionDTO transactionDTO) {
        return transactionService.addWater(transactionDTO);
    }

    @GetMapping("/money")
    public Transaction moneyToZero(@RequestBody Transaction transaction) {
        return transactionService.moneyToZero(transaction);
    }

}
