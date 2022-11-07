package com.doggy.subtype.service;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.dto.AccountDTO;
import com.doggy.subtype.exception.controller_exception.NotFoundAccountException;
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

    public Long edit(AccountDTO accountDTO) {
        Optional<Account> findAccount = accountRepository.findById(accountDTO.getId());
        if (findAccount.isPresent()) {
            // todo : dto 변환, null 파트 제외하고 변경 부분 수정.
        }
        return findAccount.get().getId();
    }

    public Account loginById(String userLoginId){
        Optional<Account> findAccount = accountRepository.findByLoginId(userLoginId);
        if (findAccount.isPresent()) {
            return findAccount.get();
        } else {
            throw new NotFoundAccountException("찾을 수 없는 회원이거나 비밀번호가 ");
        }
    }

}
