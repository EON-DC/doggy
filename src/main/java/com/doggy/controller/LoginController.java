package com.doggy.controller;

import com.doggy.dto.LoginDto;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated LoginDto loginDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }
        // todo: 로그인 인증 로직
        return "redirect:/";
    }
}
