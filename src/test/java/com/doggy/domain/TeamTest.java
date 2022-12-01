package com.doggy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TeamTest {

    Team team;

    @BeforeEach
    void init(){
        team = new Team("teamA");
    }

    @Test
    @DisplayName("")
    void tdd_for_team() throws Exception{
        // given

        // when

        // then
        assertThat(team.getName()).isInstanceOf(String.class);
        assertThat(team.getId()).isInstanceOf(Long.class);
    }

}