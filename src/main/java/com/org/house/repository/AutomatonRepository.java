package com.org.house.repository;

import com.org.house.model.Automaton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomatonRepository extends JpaRepository<Automaton, Long>
        , QuerydslPredicateExecutor<Automaton> {

    List<Automaton> findByCompanyId(long companyID);

}
