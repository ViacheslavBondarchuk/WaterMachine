package com.org.house.repository;

import com.org.house.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long>
        , QuerydslPredicateExecutor<Master> {
    
    Optional<List<Master>> findAllByCompanyId(long id);

}
