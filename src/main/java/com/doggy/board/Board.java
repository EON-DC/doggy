package com.doggy.board;

import com.doggy.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Integer id;

    private String title;
    private String contents;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime createdTime;


    //== 비즈니스 메서드 ==//
    public void updateBoard(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
