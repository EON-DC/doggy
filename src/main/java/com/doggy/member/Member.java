package com.doggy.member;


import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Member {

    private Long id;
    private String username;
    private String password;

    private MemberRole role;
    private String email;
    private LocalDateTime createdOn;

    public Member(Long id, String username, String password, MemberRole role, String email, LocalDateTime createdOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.createdOn = createdOn;
    }

    public Member() {    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorities;
    }
}
