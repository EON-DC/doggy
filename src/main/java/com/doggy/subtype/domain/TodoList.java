package com.doggy.subtype.domain;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoList {

    @Id
    @GeneratedValue
    private Long id;

    private String doing;

    private LocalDateTime createdTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "todoList")
    private Account account;

    public TodoList(String doing) {
        this.doing = doing;
        this.createdTime = LocalDateTime.now();
    }

    public void setTodo(String todo){
        doing = todo;
        createdTime = LocalDateTime.now();
    }

    //== 연관관계 편의 메서드 ==//
    public void setAccount(Account account) {
        account.getTodoList().add(this);
        this.account = account;
    }

}
