package com.doggy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    Member member;

    LocalDateTime localDateTime = LocalDateTime.now();




    @BeforeEach
    void setUp() {
        member = new Member(1L, "park", "1234", "park1@gmail.com", MemberRole.ADMIN, localDateTime);

    }

    @Test
    void 역할바꾸기() {
        member.updateRole(MemberRole.USER);
        assertThat(member.getRole()).isEqualTo(MemberRole.USER);
    }

    @Test
    void 인증가져오기(){
        Set<SimpleGrantedAuthority> authorities = member.getAuthorities();

        assertThat(authorities.size()).isEqualTo(1);

        Iterator<SimpleGrantedAuthority> iterator = authorities.iterator();
        SimpleGrantedAuthority simpleGrantedAuthority = iterator.next();

        assertThat(simpleGrantedAuthority.getAuthority()).isEqualTo("ROLE_ADMIN");
    }

    @Test
    void 회원정보_수정하기() {
        member.updateMember("4321", "park2@naver.com");
        assertThat(member.getPassword()).isEqualTo("4321");
        assertThat(member.getEmail()).isEqualTo("park2@naver.com");
    }

    /**
     *
     */


}