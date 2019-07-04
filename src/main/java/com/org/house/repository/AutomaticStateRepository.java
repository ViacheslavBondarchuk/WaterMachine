package com.org.house.repository;

import com.org.house.entity.AutomaticState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutomaticStateRepository extends JpaRepository<AutomaticState, Integer> {

    Optional<AutomaticState> findByAutomaticId(int automaticId);
}
