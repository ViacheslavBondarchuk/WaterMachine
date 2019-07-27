package com.org.house.repository;

import com.org.house.model.Automaton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutomatonRepository extends JpaRepository<Automaton, Long> {

    Optional<Automaton> findByIdAndCompanyId(long id, long companyID);

    List<Automaton> findByCompanyId(long companyID);

    void deleteByIdAndCompanyId(long id, long companyID);

}
