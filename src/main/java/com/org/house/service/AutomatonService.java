package com.org.house.service;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.repository.AutomatonRepository;
import com.org.house.security.SecurityInformation;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomatonService {

    @Autowired
    private AutomatonRepository automatonRepository;
    @Autowired
    private SecurityInformation securityInformation;

    private ModelMapper modelMapper = new ModelMapper();

    public Automaton addAutomaton(AutomatonDTO automatonDTO) {
        return automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
    }

    public List<Automaton> getAllAutomaton() {
        return automatonRepository.findByCompanyId(securityInformation.getUserCompanyId());
    }

    public void updateAutomaton(AutomatonDTO automatonDTO) throws NotFoundException {
        Automaton automaton = automatonRepository
                .findByIdAndCompanyId(automatonDTO.getId(), automatonDTO.getCompany_id())
                .orElseThrow(() -> new NotFoundException("Automat has been not found"));

        if (automaton != null) {
            automatonDTO.setCompany_id(automaton.getCompanyId());
            automatonRepository.save(modelMapper.map(automatonDTO, Automaton.class));
        }
    }


    public Automaton getOneAutomaton(long id) throws NotFoundException {
        return automatonRepository.findByIdAndCompanyId(id, securityInformation.getUserCompanyId())
                .orElseThrow(() -> new NotFoundException("Automaton has been not found "));
    }

    public void deleteAutomaton(long id) throws NotFoundException {
        automatonRepository.deleteByIdAndCompanyId(id, securityInformation
                .getUserCompanyId());
    }
}
