package com.org.house.controller;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.Transaction;
import com.org.house.service.TransactionService;
import com.org.house.transfer.NewTransaction;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Transaction getWater(@Validated(NewTransaction.class) @RequestBody TransactionDTO transactionDTO)
            throws NotFoundException {
        return transactionService.transactions(transactionDTO);
    }

    @PostMapping
    public void addWater(@Validated(NewTransaction.class) @RequestBody TransactionDTO transactionDTO)
            throws NotFoundException {
        transactionService.transactions(transactionDTO);
    }

    public Transaction incasationMoney(@Validated(NewTransaction.class) @RequestBody TransactionDTO transactionDTO)
            throws NotFoundException {
        return transactionService.transactions(transactionDTO);
    }

}
