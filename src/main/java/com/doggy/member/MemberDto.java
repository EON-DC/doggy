package com.doggy.member;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
public class MemberDto {

    private Long id;
    private String username;
    private String password;

    private MemberRole role;
    private String email;
    private LocalDateTime createdOn;

    public MemberDto(Long id, String username, String password, MemberRole role, String email, LocalDateTime createdOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.createdOn = createdOn;
    }

    public MemberDto() {    }


    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.role = member.getRole();
        this.email = member.getEmail();
        this.createdOn = member.getCreatedOn();
    }
}
