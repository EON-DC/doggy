package com.doggy.subtype.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("/")
    public String home(HttpServletRequest request){
        log.info("home controller called");
        return "index";
    }
}
