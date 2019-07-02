package com.org.house.service;

import com.org.house.entity.Transaction;
import com.org.house.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addWater (Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
