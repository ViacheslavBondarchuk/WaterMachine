package com.org.house.repository;

import com.org.house.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

    Optional<Master> findByIdAndCompanyId(long id, long companyId);

    Optional<List<Master>> findAllByCompanyId(long id);

    void deleteByIdAndCompanyId(long id, long companyId);
}
