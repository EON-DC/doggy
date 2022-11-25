package com.doggy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;

    private MemberRole role;
    private LocalDateTime createdOn;

    public Member() {
        createdOn = LocalDateTime.now();
    }

    public Member(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // 인증용 메서드
    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role));
        return authorities;
    }

    // 역할 전환용 메서드
    public Member updateRole(MemberRole role) {
        this.role = role;
        return this;
    }

    // 수정용 메서드
    public Member updateMember(String password, String email) {
        this.password = password;
        this.email = email;
        return this;
    }


}
