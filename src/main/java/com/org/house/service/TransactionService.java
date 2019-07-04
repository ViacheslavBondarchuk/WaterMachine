package com.org.house.service;

import com.org.house.entity.AutomaticState;
import com.org.house.entity.Transaction;
import com.org.house.repository.AutomaticStateRepository;
import com.org.house.repository.TransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Log4j2
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AutomaticStateRepository automaticStateRepository;

    @Transactional
    public Transaction waterAddOrGet(Transaction transaction) {
        AutomaticState automaticState = new AutomaticState.BuilderAutomaticState()
                .automaticId(transaction.getAutomaticId())
                .money(transaction.getCost())
                .water(transaction.getQuantityWater())
                .build();

        recordAutomaticState(automaticState);
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction getAllMoney(Transaction transaction) {
        AutomaticState automaticState = new AutomaticState.BuilderAutomaticState()
                .automaticId(transaction.getAutomaticId())
                .money(transaction.getCost())
                .water(transaction.getQuantityWater())
                .build();

        recordTransactionMoney(automaticState);
        return transactionRepository.save(transaction);

    }

    public List<AutomaticState> getGeneralReport() {
        return automaticStateRepository.findAll();
    }

    public List<Transaction> getReportTransaction(String dateFrom, String dateBefore) throws ParseException {
        return transactionRepository.findByDateBetween(
                new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom),
                new SimpleDateFormat("yyyy-MM-dd").parse(dateBefore));
    }


    private void recordTransactionMoney(AutomaticState automaticState) {
        automaticStateRepository.findByAutomaticId(automaticState.getAutomaticId()).
                map(automaticState1 -> {
                            automaticState.setId(automaticState1.getId());
                            automaticState.setAutomaticId(automaticState1.getAutomaticId());
                            automaticState.setMoney(0);
                            return automaticState;
                        }
                );
        automaticStateRepository.saveAndFlush(automaticState);
    }


    private void recordAutomaticState(AutomaticState automaticState) {
        automaticStateRepository.findByAutomaticId(automaticState.getAutomaticId()).
                map(automaticState1 -> {
                            automaticState.setId(automaticState1.getId());
                            automaticState.setAutomaticId(automaticState1.getAutomaticId());
                            automaticState.setWater(automaticState1.getWater() + automaticState.getWater());
                            automaticState.setMoney(automaticState1.getMoney() + automaticState.getWater());
                            return automaticState;
                        }
                );
        automaticStateRepository.saveAndFlush(automaticState);
    }
}
