package com.org.house.service;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.model.QAutomaton;
import com.org.house.repository.AutomatonRepository;
import com.org.house.security.SecurityInformation;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class AutomatonService {
    private final QAutomaton qAutomaton = QAutomaton.automaton;
    @Autowired
    private AutomatonRepository automatonRepository;
    @Autowired
    private SecurityInformation securityInformation;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JPAQueryFactory query;

    public Automaton addAutomaton(AutomatonDTO automatonDTO) {
        return automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
    }

    public List<Automaton> getAllAutomaton() {
        return automatonRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public void updateAutomaton(AutomatonDTO automatonDTO) {
        Automaton automaton = query.selectFrom(qAutomaton)
                .where(qAutomaton.id.eq(automatonDTO.getId())
                        .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();

        if (automaton.equals(null)) {
            throw new UsernameNotFoundException("Automaton has been not found");
        }
        log.debug("Automaton has been updated");
        automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
    }


    public Automaton getOneAutomaton(long id) throws NotFoundException {
        Automaton automaton = query.selectFrom(qAutomaton).where(qAutomaton.id.eq(id)
                .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).fetchOne();
        if (automaton.equals(null)) {
            throw new NotFoundException("Automaton has been not found");
        }
        return automaton;
    }

    public void deleteAutomaton(long id) throws NotFoundException {
        log.debug("Automaton was deleted");
        query.delete(qAutomaton).where(qAutomaton.id.eq(id)
                .and(qAutomaton.companyId.eq(securityInformation.getUserCompanyId()))).execute();
    }
}
