package com.org.house.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.house.dto.TransactionDTO;
import com.org.house.model.AutomatonState;
import com.org.house.model.Transaction;
import com.org.house.repository.AutomatonStateRepository;
import com.org.house.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AutomatonStateRepository automaticStateRepository;

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
		AutomatonState automatonState = AutomatonState.builder().automatonId(transaction.getAutomaticId())
				.money(transaction.getCost()).water(transaction.getQuantityWater()).build();

		transaction.setDate(new Date());
		recordTransactionMoney(automatonState);
		return transactionRepository.save(transaction);

	}

	public List<AutomatonState> getReportAutomatons() {
		return automaticStateRepository.findAll();
	}

	public List<Transaction> getReportTransaction(String dateFrom, String dateBefore) throws ParseException {
		return transactionRepository.findByDateBetween(new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom),
				new SimpleDateFormat("yyyy-MM-dd").parse(dateBefore));
	}

	private void recordTransactionMoney(AutomatonState automaticState) {
		automaticStateRepository.findByAutomatonId(automaticState.getAutomatonId()).map(automaticState1 -> {
			automaticState.setId(automaticState1.getId());
			automaticState.setAutomatonId(automaticState1.getAutomatonId());
			automaticState.setMoney(0);
			return automaticState;
		});
		automaticStateRepository.saveAndFlush(automaticState);
	}

	private void recordAutomatonState(AutomatonState automaticState) {
		automaticStateRepository.findByAutomatonId(automaticState.getAutomatonId()).map(automaticState1 -> {
			automaticState.setId(automaticState1.getId());
			automaticState.setAutomatonId(automaticState1.getAutomatonId());
			automaticState.setWater(automaticState1.getWater() + automaticState.getWater());
			automaticState.setMoney(automaticState1.getMoney() + automaticState.getWater());
			return automaticState;
		});
		automaticStateRepository.saveAndFlush(automaticState);
	}
}
