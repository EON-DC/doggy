package com.doggy.subtype.controller;

import com.doggy.subtype.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login")
public class loginController {

    private final AccountService accountService;

    @GetMapping
    public String loginForm() {
        return "login/loginForm";
    }
}
