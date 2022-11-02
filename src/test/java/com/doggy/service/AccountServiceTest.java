package com.doggy.service;

import com.doggy.domain.Account;
import com.doggy.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountRepository repository;

    @Test
    @Transactional
    public void test1(){
        Account testAccount = Account.builder()
                .profileName("Park")
                .loginId("mun")
                .loginPw("123")
                .email("abc@fake")
                .build();
        repository.save(testAccount);
        Optional<Account> findAccount = repository.findById(testAccount.getId());
        Account getAccount = findAccount.orElse(null);
        assertThat(getAccount).isEqualTo(testAccount);
    }

}