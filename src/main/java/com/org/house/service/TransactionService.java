package com.org.house.service;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.*;
import com.org.house.repository.AutomatonStateRepository;
import com.org.house.repository.TransactionRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Log4j2
@Service
public class TransactionService {

    private JPAQueryFactory query;
    private TransactionRepository transactionRepository;
    private AutomatonStateRepository automatonStateRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private QAutomatonState qAutomatonState = QAutomatonState.automatonState;

    @Autowired
    public TransactionService(JPAQueryFactory query, TransactionRepository transactionRepository
            , AutomatonStateRepository automatonStateRepository) {
        this.query = query;
        this.transactionRepository = transactionRepository;
        this.automatonStateRepository = automatonStateRepository;
    }

    @Transactional
    public Transaction transactions(TransactionDTO transactionDTO) throws NotFoundException {
        switch (transactionDTO.getType()) {
            case Refill:
                refillAutomaton(transactionDTO);
                break;
            case PurchaseByCard:
                return getWater(transactionDTO);
            case PurchaseForCash:
                return getWater(transactionDTO);
            case CashCollection:
                return incasationMoney(transactionDTO);
            case CollectionOfCards:
                return incasationMoney(transactionDTO);
            //            case CardReplenishment:
        }
        return null;
    }


    private void refillAutomaton(TransactionDTO transactionDTO) throws NotFoundException {
        AutomatonState currentState = AutomatonState.buildAutomatonState(transactionDTO);
        AutomatonState lastState = query.selectFrom(qAutomatonState)
                .where(qAutomatonState.automatonId.eq(currentState.getAutomatonId())
                        .and(qAutomatonState.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();
        if (lastState != null) {
            currentState.setMoney(lastState.getMoney());
            currentState.setWater(lastState.getWater() + currentState.getWater());

            transactionDTO.setDate(new Date());
            automatonStateRepository.save(currentState);
            transactionRepository.save(modelMapper.map(transactionDTO, Transaction.class));
            log.warn("Automaton state was updated");
        } else {
            throw new NotFoundException("Automaton state has been not found");
        }

    }


    private Transaction getWater(TransactionDTO transactionDTO) throws NotFoundException {
        AutomatonState currentState = AutomatonState.buildAutomatonState(transactionDTO);
        AutomatonState lastState = query.selectFrom(qAutomatonState)
                .where(qAutomatonState.automatonId.eq(currentState.getAutomatonId())
                        .and(qAutomatonState.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();
        if (lastState != null) {
            currentState.setMoney(lastState.getMoney() + currentState.getMoney());
            currentState.setWater(lastState.getWater() + currentState.getWater());

            log.warn("Automaton state was updated");
            transactionDTO.setDate(new Date());
            automatonStateRepository.save(currentState);
            return transactionRepository.save(modelMapper.map(transactionDTO, Transaction.class));
        } else {
            throw new NotFoundException("Automaton state has been not found");
        }

    }

    private Transaction incasationMoney(TransactionDTO transactionDTO) throws NotFoundException {
        AutomatonState currentState = AutomatonState.buildAutomatonState(transactionDTO);
        AutomatonState lastState = query.selectFrom(qAutomatonState)
                .where(qAutomatonState.automatonId.eq(currentState.getAutomatonId())
                        .and(qAutomatonState.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();
        if (lastState != null) {
            currentState.setMoney(0);
            currentState.setWater(lastState.getWater());

            log.warn("Automaton state was updated");
            transactionDTO.setDate(new Date());
            automatonStateRepository.save(currentState);
            return transactionRepository.save(modelMapper.map(transactionDTO, Transaction.class));
        } else {
            throw new NotFoundException("Automaton state has been not found");
        }

    }

}
