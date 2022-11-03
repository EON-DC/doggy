package com.doggy.subtype.controller;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.dto.AccountDTO;
import com.doggy.subtype.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public String registerAccount(@RequestBody AccountDTO accountDTO){
        Account account = accountDTO.mapperDTOToAccount();
        accountService.save(account);
        StringBuilder sb = new StringBuilder();
        sb.append("saved : ").append(account.getLoginId());
        return sb.toString();
    }



}
