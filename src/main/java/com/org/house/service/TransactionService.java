package com.org.house.service;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.repository.AutomatonStateRepository;
import com.org.house.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AutomatonStateRepository automatonStateRepository;

    @Transactional
    public Transaction addWater(TransactionDTO transactionDTO) {
        AutomatonState automatonState = AutomatonState.builder()
                .automatonId(transactionDTO.getAutomaticId())
                .money(transactionDTO.getCost())
                .water(transactionDTO.getQuantityWater())
                .build();

        transactionDTO.setDate(new Date());
        recordAutomatonState(automatonState);
        return transactionRepository.save(new ModelMapper().map(transactionDTO, Transaction.class));
    }

    @Transactional
    public Transaction getWater(TransactionDTO transactionDTO) {
        AutomatonState automatonState = AutomatonState.builder()
                .automatonId(transactionDTO.getAutomaticId())
                .money(transactionDTO.getCost())
                .water(transactionDTO.getQuantityWater())
                .build();

        transactionDTO.setDate(new Date());
        recordAutomatonState(automatonState);
        return transactionRepository.save(new ModelMapper().map(transactionDTO, Transaction.class));
    }

    @Transactional
    public Transaction moneyToZero(Transaction transaction) {
        AutomatonState automatonState = AutomatonState.builder()
                .automatonId(transaction.getAutomaticId())
                .money(transaction.getCost())
                .water(transaction.getQuantityWater())
                .build();

        transaction.setDate(new Date());
        recordTransactionMoney(automatonState);
        return transactionRepository.save(transaction);

    }

    private void recordTransactionMoney(AutomatonState currentState) {
        automatonStateRepository.findByAutomatonId(currentState.getAutomatonId()).map(previousState -> {
            currentState.setAutomatonId(previousState.getAutomatonId());
            currentState.setMoney(0);
            return currentState;
        });
        automatonStateRepository.save(currentState);
    }

    private void recordAutomatonState(AutomatonState currentState) {
        automatonStateRepository.findByAutomatonId(currentState.getAutomatonId()).map(previousState -> {
            currentState.setAutomatonId(previousState.getAutomatonId());
            currentState.setWater(previousState.getWater() + currentState.getWater());
            currentState.setMoney(previousState.getMoney() + currentState.getMoney());
            return currentState;
        });
        automatonStateRepository.save(currentState);
    }
}
