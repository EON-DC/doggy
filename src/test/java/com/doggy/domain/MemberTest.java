package com.doggy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    @DisplayName("Member 는 id, 이름, 팀(id)을 필드로 갖는다.")
    void tdd_for_MemberConstruct() throws Exception{
        // given
        Team teamA = new Team("teamA");
        Member member = new Member(1L, "park");
        member.setTeam(teamA);

        // when

        // then
        assertThat(member.getTeam().getMembers()).size().isEqualTo(1);
        assertThat(member.getId()).isInstanceOf(Long.class);
        assertThat(member.getName()).isInstanceOf(String.class);
    }


}