package com.org.house.service;

import com.org.house.model.AutomatonState;
import com.org.house.model.QAutomatonState;
import com.org.house.model.QTransaction;
import com.org.house.model.Transaction;
import com.org.house.repository.AutomatonStateRepository;
import com.org.house.repository.TransactionRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    private JPAQueryFactory query;
    private AutomatonStateRepository automatonStateRepository;
    private TransactionRepository transactionRepository;
    private SecurityInformation securityInformation;

    private QTransaction qTransaction;
    private QAutomatonState qAutomatonState;

    @Autowired
    public ReportService(JPAQueryFactory query, AutomatonStateRepository automatonStateRepository
            , TransactionRepository transactionRepository, SecurityInformation securityInformation) {
        this.query = query;
        this.automatonStateRepository = automatonStateRepository;
        this.transactionRepository = transactionRepository;
        this.securityInformation = securityInformation;
    }

    public List<AutomatonState> getReportAutomatons() {
        return automatonStateRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public AutomatonState getReportByAutomatonId(long id) throws NotFoundException {
        AutomatonState automatonState = query.selectFrom(qAutomatonState)
                .where(qAutomatonState.automatonId.eq(id)
                        .and(qAutomatonState.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (automatonState == null) {
            throw new NotFoundException("Automatn has been not found");
        }
        return automatonState;
    }

    public List<Transaction> getReportByTransactionBetweenDate(Date dateFrom, Date dateBefore) {
        return query.selectFrom(qTransaction).where(qTransaction.date.between(dateFrom, dateBefore)
                .and(qTransaction.companyId.eq(securityInformation.getUserCompanyId()))).fetch();
    }
}
