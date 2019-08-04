package com.org.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.house.model.AutomatonState;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface AutomatonStateRepository extends JpaRepository<AutomatonState, Long>
        , QuerydslPredicateExecutor<AutomatonState> {

    List<AutomatonState> findByCompanyId(long companyID);
}
