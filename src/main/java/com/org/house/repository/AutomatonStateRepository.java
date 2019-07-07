package com.org.house.repository;

import com.org.house.entity.AutomatonState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutomatonStateRepository extends JpaRepository<AutomatonState, Integer> {

    Optional<AutomatonState> findByAutomatonId(int automatonId);
}
