package com.org.house.service;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.model.QAutomaton;
import com.org.house.repository.AutomatonRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class AutomatonService {
    private final QAutomaton qAutomaton = QAutomaton.automaton;
    @Autowired
    private AutomatonRepository automatonRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JPAQueryFactory query;

    public void addAutomaton(AutomatonDTO automatonDTO) {
        automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
    }

    public List<Automaton> getAllAutomaton() {
        return automatonRepository.findByCompanyId(SecurityInformation.getUserCompanyId());
    }

    public void updateAutomaton(AutomatonDTO automatonDTO) {
        Automaton automaton = query.selectFrom(qAutomaton)
                .where(qAutomaton.id.eq(automatonDTO.getId())
                        .and(qAutomaton.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();
        if (automaton != null) {
            log.debug("Automaton has been updated");
            automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
        } else {
            throw new UsernameNotFoundException("Automaton has been not found");
        }
    }


    public Automaton getOneAutomaton(long id) {
        return query.selectFrom(qAutomaton).where(qAutomaton.id.eq(id)
                .and(qAutomaton.companyId.eq(SecurityInformation.getUserCompanyId()))).fetchOne();

    }

    public void deleteAutomaton(long id) {
        log.debug("Automaton was deleted");
        query.delete(qAutomaton).where(qAutomaton.id.eq(id)
                .and(qAutomaton.companyId.eq(SecurityInformation.getUserCompanyId()))).execute();
    }
}
