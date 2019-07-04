package com.org.house.controller;

import com.org.house.entity.AutomaticState;
import com.org.house.entity.Transaction;
import com.org.house.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/water-paid/get")
    public Transaction getWaterPaid(@RequestBody Transaction transaction) {
        return transactionService.waterAddOrGet(transaction);
    }

    @GetMapping("/water-free/get")
    public Transaction getWaterFree(@RequestBody Transaction transaction) {
        return transactionService.waterAddOrGet(transaction);
    }

    @PostMapping("/water-paid/add")
    public Transaction addWaterPaid(@RequestBody Transaction transaction) {
        return transactionService.waterAddOrGet(transaction);
    }

    @PostMapping("/water-free/add")
    public Transaction addWaterFree(@RequestBody Transaction transaction) {
        return transactionService.waterAddOrGet(transaction);
    }

    @GetMapping("/money/get")
    public Transaction getAllMoney(@RequestBody Transaction transaction) {
        return transactionService.getAllMoney(transaction);
    }

    @GetMapping("/report/general")
    public List<AutomaticState> getGeneralReport() {
        return transactionService.getGeneralReport();
    }

    @GetMapping("/report")
    public List<Transaction> getReportTransaction(@RequestParam String dateFrom,
                                                  @RequestParam String dateBefore) throws ParseException {
        return transactionService.getReportTransaction(dateFrom, dateBefore);
    }

}
