package com.doggy.subtype.controller;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.dto.AccountDTO;
import com.doggy.subtype.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/add")
    public String addForm(){
        return "account/addForm";
    }

    @PostMapping("/add")
    public String accountAdd(AccountDTO dto){
        Account account = new Account(dto.getLoginId(), dto.getLoginPw(), dto.getProfileName(),dto.getEmail());
        accountService.save(account);
        return "account/joinInfo";
    }


}
