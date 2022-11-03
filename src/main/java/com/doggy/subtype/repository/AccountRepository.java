package com.doggy.subtype.repository;

import com.doggy.subtype.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

}
