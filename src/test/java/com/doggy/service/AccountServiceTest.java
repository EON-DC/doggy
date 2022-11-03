package com.doggy.service;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountRepository repository;

    @Test
    @Transactional
    @DisplayName("계정을 등록하면 Repository에서 조회할 수 있어야합니다")
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

    @Test
    @Transactional
    @DisplayName("잘못된 타입이 들어갈 경우 예외가 발생해야합니다.")
    public void test2(){
        Account testAccount = Account.builder()
                .profileName("Park")
                .loginId("mun")
                .loginPw("123")
                .email("abc@fake")
                .build();
        repository.save(testAccount);

    }

}