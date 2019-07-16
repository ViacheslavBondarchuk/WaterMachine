package com.org.house.service;

import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.repository.AutomatonStateRepository;
import com.org.house.repository.TransactionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private AutomatonStateRepository automatonStateRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<AutomatonState> getReportAutomatons() {
        return automatonStateRepository.findAll();
    }

    public AutomatonState getReportByAutomatonId(long id) throws NotFoundException {
        return automatonStateRepository.findByAutomatonId(id).orElseThrow(() -> new NotFoundException("Automaton " + id + " was not found"));
    }

    public List<Transaction> getReportByTransactionBetweenDate(Date dateFrom, Date dateBefore) {
        return transactionRepository.findByDateBetween(dateFrom, dateBefore);
    }
}
