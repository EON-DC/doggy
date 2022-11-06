package com.doggy.subtype.repository;

import com.doggy.subtype.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;
    @Test
    void test01(){
        Account testAccount = new Account("mun", "1234", "fake", "2@na.com");
        accountRepository.save(testAccount);
        Account findAccount = accountRepository.findById(testAccount.getId()).get();
        Assertions.assertThat(findAccount).isEqualTo(testAccount);

    }

}