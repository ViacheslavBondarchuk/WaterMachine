package com.org.house.service;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.model.QAutomaton;
import com.org.house.repository.AutomatonRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomatonService {
    private final QAutomaton qAutomaton = QAutomaton.automaton;
    @Autowired
    private AutomatonRepository automatonRepository;
    @Autowired
    private JPAQueryFactory query;
    @Autowired
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();


    public void addAutomaton(AutomatonDTO automatonDTO) {
        automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
    }

    public List<Automaton> getAllAutomaton() {
        return automatonRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public void updateAutomaton(AutomatonDTO automatonDTO) {
        Automaton automaton = query.selectFrom(qAutomaton)
                .where(qAutomaton.id.eq(automatonDTO.getId())
                        .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (automaton != null) {
            automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
        } else {
            throw new UsernameNotFoundException("Automaton has been not found");
        }
    }

    public Automaton getOneAutomaton(long id) {
        return query.selectFrom(qAutomaton).where(qAutomaton.id.eq(id)
                .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();

    }

    public void deleteAutomaton(long id) {
        query.delete(qAutomaton).where(qAutomaton.id.eq(id)
                .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).execute();
    }

    public List<Automaton> getMasterAutomaton(long id) {
        return query.selectFrom(qAutomaton).where(qAutomaton.masterId.eq(id)
                .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).fetch();
    }
}
