package com.doggy.todo;

import com.doggy.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Integer saveTodo(Todo todo, Member member){
        todo.setMember(member);
        todoRepository.save(todo);
        return todo.getId();
    }

    public Integer editTodo(Integer todoId, String todo, String details){
        Todo findTodo = selectTodo(todoId);
        findTodo.updateTodo(todo, details);
        return todoId;
    }

    public Todo selectTodo(Integer todoId){
        Todo findTodo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalStateException("조회한 Id가 없습니다."));
        return findTodo;
    }

    public List<Todo> selectAllTodo() {
        return new ArrayList<>(todoRepository.findAll());
    }

    public Integer deleteTodo(Integer todoId) {
        todoRepository.delete(selectTodo(todoId));
        return todoId;
    }

    public Integer finishTodo(Integer todoId) {
        Todo findTodo = selectTodo(todoId);
        findTodo.finish();
        return todoId;
    }

    public Integer demolishTodo(Integer todoId) {
        Todo findTodo = selectTodo(todoId);
        findTodo.demolish();
        return todoId;
    }

}
