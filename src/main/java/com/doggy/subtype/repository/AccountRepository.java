package com.doggy.subtype.repository;

import com.doggy.subtype.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "Select a from Account a where a.loginId = :loginId")
    public Optional<Account> findByLoginId(@Param("loginId") String loginId);

}
