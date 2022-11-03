package com.doggy.subtype.service;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Long save(Account account) {
        accountRepository.save(account);
        return account.getId();
    }

    public Long changeProfileName(Account account, String name) {
        Optional<Account> findAccount = accountRepository.findById(account.getId());
        Account inputAccount = findAccount.orElse(null);
        // todo : null 일 경우 예외 발생
        inputAccount.changeProfileName(name);
        return account.getId();
    }


}
