package com.org.house.service;

import com.org.house.entity.AutomatonState;
import com.org.house.entity.Transaction;
import com.org.house.repository.TransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.org.house.repository.AutomatonStateRepository;

@Log4j2
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AutomatonStateRepository automaticStateRepository;

    @Transactional
    public Transaction waterAddOrGet(Transaction transaction) {
        AutomatonState automatonState = new AutomatonState().builder()
                .automatonId(transaction.getAutomaticId())
                .money(transaction.getCost())
                .water(transaction.getQuantityWater())
                .build();

        transaction.setDate(new Date());
        recordAutomaticState(automatonState);
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction getAllMoney(Transaction transaction) {
        AutomatonState automatonState = new AutomatonState().builder()
                .automatonId(transaction.getAutomaticId())
                .money(transaction.getCost())
                .water(transaction.getQuantityWater())
                .build();

        transaction.setDate(new Date());
        recordTransactionMoney(automatonState);
        return transactionRepository.save(transaction);

    }

    public List<AutomatonState> getReportAutomatons() {
        return automaticStateRepository.findAll();
    }

    public List<Transaction> getReportTransaction(String dateFrom, String dateBefore) throws ParseException {
        return transactionRepository.findByDateBetween(
                new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom),
                new SimpleDateFormat("yyyy-MM-dd").parse(dateBefore));
    }

    private void recordTransactionMoney(AutomatonState automaticState) {
        automaticStateRepository.findByAutomatonId(automaticState.getAutomatonId()).
                map(automaticState1 -> {
                    automaticState.setId(automaticState1.getId());
                    automaticState.setAutomatonId(automaticState1.getAutomatonId());
                    automaticState.setMoney(0);
                    return automaticState;
                }
                );
        automaticStateRepository.saveAndFlush(automaticState);
    }

    private void recordAutomaticState(AutomatonState automaticState) {
        automaticStateRepository.findByAutomatonId(automaticState.getAutomatonId()).
                map(automaticState1 -> {
                    automaticState.setId(automaticState1.getId());
                    automaticState.setAutomatonId(automaticState1.getAutomatonId());
                    automaticState.setWater(automaticState1.getWater() + automaticState.getWater());
                    automaticState.setMoney(automaticState1.getMoney() + automaticState.getWater());
                    return automaticState;
                }
                );
        automaticStateRepository.saveAndFlush(automaticState);
    }
}
