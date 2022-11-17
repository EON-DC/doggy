package com.doggy.todo;

import com.doggy.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.doggy.todo.TodoStatus.*;

@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Integer id;

    private String todo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 작성자 노출용

    private String details;


    private LocalDateTime createdTime;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;


    //== 양방향 연관관계 메서드 ==//
    public void setMember(Member member){
        this.member = member;
        member.getTodos().add(this);
    }

    //== 비즈니스 메서드 ==//
    public void updateTodo(String todo, String details) {
        this.todo = todo;
        this.details = details;
    }

    public void finish() {
        this.status = FINISHED;
    }

    public void demolish(){
        this.status = READY;
    }
}
