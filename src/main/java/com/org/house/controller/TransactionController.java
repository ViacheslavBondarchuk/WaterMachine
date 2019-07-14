package com.org.house.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.service.TransactionService;
import com.org.house.transfer.New;

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
    public Transaction getAllMoney(@RequestBody Transaction transaction) {
        return transactionService.moneyToZero(transaction);
    }

    @GetMapping("/reports/automatons")
    public List<AutomatonState> getReportAutomatons() {
        return transactionService.getReportAutomatons();
    }

    @GetMapping("/reports/transactions")
    public List<Transaction> getReportTransaction(@RequestParam String dateFrom,
            @RequestParam String dateBefore) throws ParseException {
        return transactionService.getReportTransaction(dateFrom, dateBefore);
    }

}
