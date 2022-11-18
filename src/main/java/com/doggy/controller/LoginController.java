package com.doggy.controller;

import com.doggy.dto.LoginDto;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<String> loginUser() {
        return new ResponseEntity<>("Hello User!", HttpStatus.OK);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<String> loginAdmin() {
        return new ResponseEntity<>("Hello Admin!", HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public String login(@Validated LoginDto loginDto, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "loginForm";
//        }
//        // todo: 로그인 인증 로직
//        return "redirect:/";
//    }
}
