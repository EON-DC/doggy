package com.doggy.subtype.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @UniqueElements
    @Length(max = 12)
    private String loginId;

    @NotNull
    @Length(max = 12)
    private String loginPw;

    @UniqueElements
    @Length(max = 10)
    private String profileName;
    private String email;

    private Integer profileImageCode = null;

    private Role role = Role.USER;

    @OneToMany(mappedBy = "account")
    private List<TodoList> todoList = new ArrayList<>();


    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public Account(String loginId, String loginPw, String profileName, String email) {
        Assert.hasText(loginId, "loginId must not be empty");
        Assert.hasText(loginPw, "loginPw must not be empty");
        Assert.hasText(profileName, "profileName must not be empty");
        Assert.hasText(email, "email must not be empty");

        this.loginId = loginId;
        this.loginPw = loginPw;
        this.profileName = profileName;
        this.email = email;
        this.createdDate = LocalDateTime.now();
    }

    public void changeProfileName(String name) {
        this.profileName = name;
        lastModifiedDate = LocalDateTime.now();
    }
}
