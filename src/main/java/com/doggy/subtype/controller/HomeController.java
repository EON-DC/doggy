package com.doggy.subtype.controller;

import com.doggy.subtype.domain.TodoList;
import com.doggy.subtype.repository.TodoListRepository;
import com.doggy.subtype.service.TodoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final TodoListService todoListService;

    @GetMapping("/")
    public String home(Model model) {
        log.info("home controller called");
        List<TodoList> allTodo = todoListService.findAll();

        // local Time 전송
        LocalDateTime timestamp = LocalDateTime.now();
        String dayOfWeek = String.valueOf(
                timestamp.getDayOfWeek().getDisplayName
                        (TextStyle.NARROW, Locale.KOREAN)) + "요일";


        // model attribute 추가
        model.addAttribute("localDateTime", timestamp);
        model.addAttribute("dayOfWeek", dayOfWeek);
        model.addAttribute("todoList", allTodo);
        return "home";
    }
}
