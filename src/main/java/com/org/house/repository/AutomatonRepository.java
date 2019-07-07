package com.org.house.repository;

import com.org.house.entity.Automaton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomatonRepository extends JpaRepository<Automaton, Integer> {
}
