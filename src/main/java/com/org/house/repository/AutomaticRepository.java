package com.org.house.repository;

import com.org.house.entity.Automatic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomaticRepository extends JpaRepository<Automatic, Long> {
}
