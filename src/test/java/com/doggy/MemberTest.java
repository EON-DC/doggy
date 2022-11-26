package com.doggy;

import com.doggy.member.Member;
import com.doggy.member.MemberDto;
import com.doggy.member.MemberRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    /**
     * 회원의 기능
     * - id, username, password, email, createdOn 필드 가짐
     * - security 로그인을 위해 simpleAuthorities 를 리턴할 수 있어야함
     * - dto 객체로 변환 가능해야함
     */

    Member underTest;


    @BeforeEach
    void beforeEach() {
        underTest = new Member(1L, "park", "password", MemberRole.USER, "park@gmail.com", LocalDateTime.now());
    }

    @Test
    @DisplayName("회원_생성")
    void test1() {
        assertThat(underTest).isInstanceOf(Member.class);
    }

    @Test
    @DisplayName("회원은_요구된_필드를_갖는다")
    void test2() {
        assertThat(underTest.getId()).isInstanceOf(Long.class);
        assertThat(underTest.getUsername()).isInstanceOf(String.class);
        assertThat(underTest.getPassword()).isInstanceOf(String.class);
        assertThat(underTest.getRole()).isInstanceOf(MemberRole.class);
        assertThat(underTest.getEmail()).isInstanceOf(String.class);
        assertThat(underTest.getCreatedOn()).isInstanceOf(LocalDateTime.class);
    }

    @Test
    @DisplayName("회원은_SimpleAuthorities를_반환한다")
    void test3() {
        assertThat(underTest.getAuthorities()).isInstanceOf(Set.class);
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>(underTest.getAuthorities());
        assertThat(list.get(0).getAuthority()).isEqualTo("ROLE_USER");
    }

    @Test
    @DisplayName("회원은 dto객체로 변환할 수 있어야한다.")
    void test4() {
        MemberDto memberDto = new MemberDto(underTest);
        assertThat(memberDto).isInstanceOf(MemberDto.class);

        assertThat(memberDto.getId()).isInstanceOf(Long.class);
        assertThat(memberDto.getUsername()).isInstanceOf(String.class);
        assertThat(memberDto.getPassword()).isInstanceOf(String.class);
        assertThat(memberDto.getRole()).isInstanceOf(MemberRole.class);
        assertThat(memberDto.getEmail()).isInstanceOf(String.class);
        assertThat(memberDto.getCreatedOn()).isInstanceOf(LocalDateTime.class);
    }

}
