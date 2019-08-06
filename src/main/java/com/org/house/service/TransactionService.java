package com.org.house.service;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.AutomatonState;
import com.org.house.model.QAutomatonState;
import com.org.house.model.Transaction;
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
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();
    private QAutomatonState qAutomatonState = QAutomatonState.automatonState;

    @Autowired
    public TransactionService(JPAQueryFactory query, TransactionRepository transactionRepository
            , AutomatonStateRepository automatonStateRepository, SecurityInformation securityInformation) {
        this.query = query;
        this.transactionRepository = transactionRepository;
        this.automatonStateRepository = automatonStateRepository;
        this.securityInformation = securityInformation;
    }

    @Transactional
    public Transaction addWater(TransactionDTO transactionDTO) throws NotFoundException {
        AutomatonState automatonState = AutomatonState.builder()
                .automatonId(transactionDTO.getAutomaticId())
                .companyId(securityInformation.getUserCompanyId())
                .money(transactionDTO.getCost())
                .water(transactionDTO.getQuantityWater())
                .build();

        transactionDTO.setDate(new Date());
        recordAutomatonState(automatonState);
        return transactionRepository.save(modelMapper.map(transactionDTO, Transaction.class));
    }

    @Transactional
    public Transaction getWater(TransactionDTO transactionDTO) throws NotFoundException {
        AutomatonState automatonState = AutomatonState.builder()
                .automatonId(transactionDTO.getAutomaticId())
                .companyId(securityInformation.getUserCompanyId())
                .money(transactionDTO.getCost())
                .water(transactionDTO.getQuantityWater())
                .build();

        transactionDTO.setDate(new Date());
        recordAutomatonState(automatonState);
        return transactionRepository.save(modelMapper.map(transactionDTO, Transaction.class));
    }

    @Transactional
    public Transaction moneyToZero(Transaction transaction) throws NotFoundException {
        AutomatonState automatonState = AutomatonState.builder()
                .automatonId(transaction.getAutomatonId())
                .companyId(securityInformation.getUserCompanyId())
                .money(transaction.getCost())
                .water(transaction.getQuantityWater())
                .build();

        transaction.setDate(new Date());
        recordTransactionMoney(automatonState);
        return transactionRepository.save(transaction);
    }

    private final void recordTransactionMoney(AutomatonState currentState) throws NotFoundException {
        AutomatonState lastState = query.selectFrom(qAutomatonState)
                .where(qAutomatonState.automatonId.eq(currentState.getAutomatonId())
                        .and(qAutomatonState.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (lastState != null) {
            currentState.setMoney(0);
            automatonStateRepository.save(currentState);
            log.debug(String.format("Transaction by %d automaton id was record", currentState.getAutomatonId()));
        } else {
            throw new NotFoundException("Automaton has been not found");
        }
    }

    private final void recordAutomatonState(AutomatonState currentState) throws NotFoundException {
        AutomatonState lasState = query.selectFrom(qAutomatonState)
                .where(qAutomatonState.automatonId.eq(currentState.getAutomatonId())
                        .and(qAutomatonState.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (lasState != null) {
            currentState.setWater(lasState.getWater() + currentState.getWater());
            currentState.setMoney(lasState.getMoney() + currentState.getMoney());
            automatonStateRepository.save(currentState);
            log.debug("Automaton by %d automaton id was record");
        } else {
            throw new NotFoundException("Automaton has been not found");
        }
    }
}
