package com.doggy.service;

import com.doggy.domain.Account;
import com.doggy.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
