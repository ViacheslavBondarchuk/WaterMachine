package com.org.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.house.model.AutomatonState;

import java.util.List;
import java.util.Optional;

public interface AutomatonStateRepository extends JpaRepository<AutomatonState, Long> {
    Optional<AutomatonState> findByAutomatonIdAndCompanyId(long automatonId, long companyID);

    List<AutomatonState> findByCompanyId(long companyID);
}
