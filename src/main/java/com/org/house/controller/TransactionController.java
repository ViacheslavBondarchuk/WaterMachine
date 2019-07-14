package com.org.house.controller;

import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/waters")
    public Transaction getWater(@RequestBody Transaction transaction) {
        return transactionService.operationsWithWater(transaction);
    }

    @PostMapping("/waters")
    public Transaction addWater(@RequestBody Transaction transaction) {
        return transactionService.operationsWithWater(transaction);
    }

    @GetMapping("/moneys")
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
