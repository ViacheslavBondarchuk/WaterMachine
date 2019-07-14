package com.org.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.house.model.Automaton;

@Repository
public interface AutomatonRepository extends JpaRepository<Automaton, Long> {
}
