package com.org.house.controller;

import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.service.ReportService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/automatons/{id}")
    public AutomatonState getReportByAutomatonId(@PathVariable long id) throws NotFoundException {
        return reportService.getReportByAutomatonId(id);
    }

    @GetMapping("/reports/automatons")
    public List<AutomatonState> getReportAutomatons() {
        return reportService.getReportAutomatons();
    }

    @GetMapping("/reports/transactions")
    public List<Transaction> getReportByTransactionBetweenDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateBefore) {
        return reportService.getReportByTransactionBetweenDate(dateFrom, dateBefore);
    }


}
