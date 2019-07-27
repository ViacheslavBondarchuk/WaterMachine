package com.org.house.service;

import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.repository.AutomatonStateRepository;
import com.org.house.repository.TransactionRepository;
import com.org.house.security.SecurityInformation;
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
    @Autowired
    private SecurityInformation securityInformation;

    public List<AutomatonState> getReportAutomatons() {
        return automatonStateRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public AutomatonState getReportByAutomatonId(long id) throws NotFoundException {
        return automatonStateRepository.findByAutomatonIdAndCompanyId(id, securityInformation.getUserCompanyId())
                .orElseThrow(
                        () -> new NotFoundException("Automaton has been not found"));
    }

    public List<Transaction> getReportByTransactionBetweenDate(Date dateFrom, Date dateBefore) {
        return transactionRepository.findByDateBetweenAndCompanyId(dateFrom, dateBefore, securityInformation.getUserCompanyId());
    }
}
