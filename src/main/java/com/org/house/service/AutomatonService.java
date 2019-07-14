package com.org.house.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.house.dto.AutomatonDTO;
import com.org.house.model.Automaton;
import com.org.house.repository.AutomatonRepository;

import javassist.NotFoundException;

@Service
public class AutomatonService {

	@Autowired
	private AutomatonRepository automatonRepository;

	public Automaton addAutomatic(AutomatonDTO automatonDTO) {
		return automatonRepository.save(new ModelMapper().map(automatonDTO, Automaton.class));
	}

	public List<Automaton> getAllAutomatic() {
		return automatonRepository.findAll();
	}

	public Automaton updateAutomaton(AutomatonDTO automatonDTO) {
		return automatonRepository.save(new ModelMapper().map(automatonDTO, Automaton.class));
	}

	public Automaton getOneAutomaton(long id) throws NotFoundException {
		return automatonRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Automaton has been not found "));
	}

	public void deleteAutomaton(long id) {
		automatonRepository.deleteById(id);
	}
}
