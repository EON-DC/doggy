package com.doggy.service;

import com.doggy.domain.Member;
import com.doggy.domain.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember() {

    }

}
