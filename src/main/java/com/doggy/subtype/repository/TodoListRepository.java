package com.doggy.subtype.repository;

import com.doggy.subtype.domain.Account;
import com.doggy.subtype.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
