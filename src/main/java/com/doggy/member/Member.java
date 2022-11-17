package com.doggy.member;

import com.doggy.auth.ApplicationUserRole;
import com.doggy.board.Board;
import com.doggy.todo.Todo;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {


    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Integer id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<Todo> todos = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    private LocalDateTime createdTime;

    @Enumerated(EnumType.STRING)
    private ApplicationUserRole userRole;

    //== 수정 메소드 ==//
    public void updateMember(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
