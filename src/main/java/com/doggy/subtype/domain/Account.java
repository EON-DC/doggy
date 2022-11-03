package com.doggy.subtype.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @Length(max = 12)
    private String loginId;

    @NotNull
    @Length(max = 12)
    private String loginPw;

    @NotNull
    @Length(max = 10)
    private String profileName;


    private String email;

    private Integer profileImageCode;
    private Role role;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    @Builder
    public Account(Long id, String loginId, String loginPw, String profileName, String email) {
        this.id = id;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.profileName = profileName;
        this.email = email;
    }

    public void changeProfileName(String name) {
        this.profileName = name;
    }
}
