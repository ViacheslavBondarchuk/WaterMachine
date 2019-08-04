package com.org.house.repository;

import com.org.house.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>
        , QuerydslPredicateExecutor<Owner> {
}
