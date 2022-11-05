package com.doggy.subtype.controller;

import com.doggy.subtype.domain.TodoList;
import com.doggy.subtype.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TodoController {

    private final TodoListRepository todoListRepository;

    @PostMapping("/todoList/add")
    public String addTodo(@RequestParam String doing){
        log.info("todoList controller called");
        TodoList todoList = new TodoList(doing);
        todoListRepository.save(todoList);
        return "redirect:/";
    }
}
