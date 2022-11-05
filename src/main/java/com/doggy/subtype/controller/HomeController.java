package com.doggy.subtype.controller;

import com.doggy.subtype.domain.TodoList;
import com.doggy.subtype.repository.TodoListRepository;
import com.doggy.subtype.service.TodoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final TodoListService todoListService;

    @GetMapping("/")
    public String home(Model model){
        log.info("home controller called");
        List<TodoList> allTodo = todoListService.findAll();
        model.addAttribute("todoList", allTodo);
        return "home";
    }
}
