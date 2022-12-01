package com.doggy.domain;


import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "team_id")
    private Team team;

    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member(String name) {
        this.name = name;
        this.team = null;
    }

    public void setTeam(Team team) {
        if (this.team != null) {
            getTeam().getMembers().remove(this);
        }

        this.team = team;
        getTeam().getMembers().add(this);

    }


}
