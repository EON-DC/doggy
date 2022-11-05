package com.doggy.subtype.service;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.domain.TodoList;
import com.doggy.subtype.repository.AccountRepository;
import com.doggy.subtype.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public void saveTodo(TodoList toDoList) {
        todoListRepository.save(toDoList);
    }

    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }


}
