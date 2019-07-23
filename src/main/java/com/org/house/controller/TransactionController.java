package com.org.house.controller;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.Transaction;
import com.org.house.service.TransactionService;
import com.org.house.transfer.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    @Secured("USER")
    public Transaction getWater(@Validated(NewUser.class) @RequestBody TransactionDTO transactionDTO) {
        return transactionService.getWater(transactionDTO);
    }

    @PostMapping
    @Secured("ADMIN")
    public Transaction addWater(@Validated(NewUser.class) @RequestBody TransactionDTO transactionDTO) {
        return transactionService.addWater(transactionDTO);
    }

    @GetMapping("/money")
    @Secured("ADMIN")
    public Transaction moneyToZeroAll(@RequestBody Transaction transaction) {
        return transactionService.moneyToZero(transaction);
    }

}
