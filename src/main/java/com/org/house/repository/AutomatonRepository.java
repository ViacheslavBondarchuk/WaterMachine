package com.org.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.house.model.Automaton;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutomatonRepository extends JpaRepository<Automaton, Long> {
    Optional<Automaton> findByIdAndCompanyId(long id, long companyID);

    List<Automaton> findByCompanyId(long companyID);

    Automaton deleteByIdAndCompanyId(long id, long companyID);
}
