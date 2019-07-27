package com.org.house.repository;

import com.org.house.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndCompanyId(long id, long companyId);

    Optional<User> findByUsername(String username);

    List<User> findByCompanyId(long companyID);
}