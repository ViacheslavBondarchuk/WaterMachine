package com.org.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.house.model.AutomatonState;

import java.util.Optional;

public interface AutomatonStateRepository extends JpaRepository<AutomatonState, Long> {

    Optional<AutomatonState> findByAutomatonId(long automatonId);
}
